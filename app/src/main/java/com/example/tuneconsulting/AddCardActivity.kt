package com.example.tuneconsulting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tuneconsulting.cards.CardsViewModel
import com.example.tuneconsulting.databinding.ActivityAddCardBinding
import com.example.tuneconsulting.data.Card
import com.example.tuneconsulting.utils.MaskWatcher

class AddCardActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddCardBinding
    private lateinit var viewModel: CardsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CardsViewModel::class.java)
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
                    viewModel.saveCard(Card(number = cardNumber, expiry = expiry))
                    startActivity(Intent(baseContext,MainActivity::class.java))
                }



            }
        }

    }
}