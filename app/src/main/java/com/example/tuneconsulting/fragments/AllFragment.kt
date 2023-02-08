package com.example.tuneconsulting.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuneconsulting.adapters.RecyclerViewAdapter
import com.example.tuneconsulting.R
import com.example.tuneconsulting.model.Card
import com.google.firebase.database.*


class AllFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    var cardArrayList= ArrayList<Card>()
    lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_all, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Kartalarim")
        databaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                cardArrayList.clear()
                for (dataSnapshot : DataSnapshot in snapshot.children){
                    val card = dataSnapshot.getValue(Card::class.java)
                    cardArrayList.add(card!!)
                }
                val recyclerViewAdapter = RecyclerViewAdapter(activity!!, cardArrayList)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = recyclerViewAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        return view



    }
}

