package com.mabnets.korutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabnets.korutines.models.Quote
import com.mabnets.korutines.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Quotesviewmodel:ViewModel() {

    val Quotez:LiveData<List<Quote>?> = MutableLiveData()

    init {
        viewModelScope.launch {
            Quotez as MutableLiveData
            Quotez.value=getquotez()
        }
    }



    private suspend fun getquotez():List<Quote>?{
        return withContext(Dispatchers.IO){
            MyApi().getQuotes().body()?.quotes
        }
    }
}