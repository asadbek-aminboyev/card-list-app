package com.example.tuneconsulting.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuneconsulting.R
import com.example.tuneconsulting.model.Card

class RecyclerViewAdapter constructor(
    val context: Context,
    private val cardList: ArrayList<Card>
) : RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_card, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = cardList[position]
        holder.cardNum.text = currentItem.number.toString()
        holder.cardYear.text = currentItem.expiry
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardNum: TextView = itemView.findViewById(R.id.textCardNum)
        val cardYear: TextView = itemView.findViewById(R.id.textCarYear)
    }

}