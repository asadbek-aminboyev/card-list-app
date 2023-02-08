package com.example.tuneconsulting.cards

import androidx.lifecycle.MutableLiveData
import com.example.tuneconsulting.data.Card
import com.example.tuneconsulting.data.Response
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CardRepository(
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val cardRef: DatabaseReference = rootRef.child("Kartalarim")
) {
    fun getResponseFromRealtimeDatabaseUsingLiveData() : MutableLiveData<Response> {
        val mutableLiveData = MutableLiveData<Response>()
        cardRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.cards = result.children.map { snapShot ->
                        snapShot.getValue(Card::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            mutableLiveData.value = response
        }
        return mutableLiveData
    }

    fun saveCard(card: Card) {
        cardRef.push().setValue(card).addOnCompleteListener({
            //
        }).addOnFailureListener {
            //
        }
    }
}