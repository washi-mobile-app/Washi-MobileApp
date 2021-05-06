package com.washi.washi

import android.app.Activity
import android.content.Intent
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

        val intent = Intent()
        intent.putExtra("name", name)
        intent.putExtra("address", address)
        intent.putExtra("price", price)


        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}