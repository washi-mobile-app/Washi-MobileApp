package com.washi.washi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_search_laundries.*

class OrderActivity : AppCompatActivity() {
    lateinit var laundry: Laundry
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        loadLaundry()
    }

    private fun loadLaundry() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("laundry")

        laundry = gson.fromJson(stringObj, Laundry::class.java) ?: Laundry(null, "", null, "","",null)

        if (laundry.name != null)
        {
            TvLaundryName.setText(laundry.name)
            TvDistrict.setText(laundry.district)
            TvEmail.setText(laundry.email)
            TvPhone.setText(laundry.phone.toString())
        }
    }
}