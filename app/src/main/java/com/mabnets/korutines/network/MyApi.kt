package com.mabnets.korutines.network

import com.mabnets.korutines.models.QuotesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    @GET("mvvm/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>
    companion object {
        operator fun invoke(): MyApi {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okclients = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder().client(okclients)
                .baseUrl("http://api.simplifiedcoding.in/course-apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}