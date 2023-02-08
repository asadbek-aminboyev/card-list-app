package com.example.tuneconsulting.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tuneconsulting.data.Card
import com.example.tuneconsulting.data.Response

class CardsViewModel (
    private val repository: CardRepository = CardRepository()
): ViewModel() {
    fun getResponseUsingLiveData() : LiveData<Response> {
        return repository.getResponseFromRealtimeDatabaseUsingLiveData()
    }

    fun saveCard(card: Card) {
        repository.saveCard(card);
    }

}