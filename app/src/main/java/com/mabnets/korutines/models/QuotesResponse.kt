package com.mabnets.korutines.models

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)