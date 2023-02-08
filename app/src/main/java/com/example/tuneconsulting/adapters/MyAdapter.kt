package com.example.tuneconsulting.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tuneconsulting.fragments.*

internal class MyAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                AllFragment()
            }

            1 -> {
                BelovedFragment()
            }

            2 -> {
                UzCardFragment()
            }

            3 -> {
                HumoFragment()
            }

            4 -> {
                XalqaroKartalarFragment()
            }

            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }


}