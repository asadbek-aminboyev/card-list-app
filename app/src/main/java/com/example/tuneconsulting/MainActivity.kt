package com.example.tuneconsulting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.tuneconsulting.adapters.TabAdapter
import com.example.tuneconsulting.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imgAdd.setOnClickListener {
            startActivity(Intent(this,AddCardActivity::class.java))
            finish()
        }



        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Hammasi"))
        tabLayout.addTab(tabLayout.newTab().setText("Sevimli"))
        tabLayout.addTab(tabLayout.newTab().setText("UzCard"))
        tabLayout.addTab(tabLayout.newTab().setText("HUMO"))
        tabLayout.addTab(tabLayout.newTab().setText("Xalqaro kartalar"))

        tabLayout.tabGravity = TabLayout.GRAVITY_CENTER

        val adapter = TabAdapter(this,supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })




    }

}