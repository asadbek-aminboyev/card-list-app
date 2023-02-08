package com.example.tuneconsulting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tuneconsulting.databinding.ActivityAddCardBinding
import com.example.tuneconsulting.model.Card
import com.example.tuneconsulting.utils.MaskWatcher
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddCardActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddCardBinding
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Kartalarim")
        binding.imgBack2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.etNumber.addTextChangedListener(MaskWatcher("#### #### #### ####"))
        binding.etYear.addTextChangedListener(MaskWatcher("##/##"))

        binding.apply {
            btnAdd.setOnClickListener {
                val cardNumber = etNumber.text.toString()
                val expiry = etYear.text.toString()
                if (cardNumber.length != 16 && cardNumber.length != 19) {
                    etNumber.error = "Karta raqami xato"
                } else if (cardNumber.length == 16 && cardNumber.contains(" ")) {
                    etNumber.error = "Karta raqami xato"
                } else if (expiry.length != 5) {
                    etYear.error = "Muddati xato"
                } else {
                    databaseReference
                        .push()
                        .setValue(Card(etNumber.text.toString(), etYear.text.toString()))
                    startActivity(Intent(baseContext,MainActivity::class.java))
                }



            }
        }

    }
}