package com.example.tuneconsulting.data

data class Response(
    var cards: List<Card>? = null,
    var exception: Exception? = null
)