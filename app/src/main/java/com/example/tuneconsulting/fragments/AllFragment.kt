package com.example.tuneconsulting.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuneconsulting.adapters.RecyclerViewAdapter
import com.example.tuneconsulting.R
import com.example.tuneconsulting.cards.CardsViewModel
import com.google.firebase.database.*


class AllFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: CardsViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_all, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        viewModel = ViewModelProvider(this).get(CardsViewModel::class.java)
        viewModel.getResponseUsingLiveData().observe(viewLifecycleOwner) {
            val recyclerViewAdapter =
                it.cards?.let { it1 -> RecyclerViewAdapter(requireActivity(), it1) }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = recyclerViewAdapter
            }
        }
        return view
    }
}

