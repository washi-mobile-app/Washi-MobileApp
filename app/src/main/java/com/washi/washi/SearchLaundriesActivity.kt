package com.washi.washi

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search_laundries.*

class SearchLaundriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_laundries)

        btSearchLaundries.setOnClickListener {
            searchLaundries()
        }
    }

    private fun searchLaundries() {
        val name = etLaundryName.text.toString()
        val address = etLaundryAddress.text.toString()
        val price = etLaundryPrice.text.toString()
    }
}