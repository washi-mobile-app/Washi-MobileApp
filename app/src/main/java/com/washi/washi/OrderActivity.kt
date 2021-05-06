package com.washi.washi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_search_laundries.*

class OrderActivity : AppCompatActivity() {
    var laundries = ArrayList<Laundry>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        loadLaundries()
        setOrder()
    }

    private fun setOrder() {
        TvLaundryName.text = laundries[1].name
        TvDistrict.text = laundries[1].district
        TvEmail.text = laundries[1].email
        TvPhone.text = laundries[1].phone.toString()
    }

    private fun loadLaundries() {
        laundries.add(Laundry("Lavanderia Akiraki", "Av. La marina", 9.99f, "akira@gmail.com", "San Miguel", 958158852))
        laundries.add(Laundry("Lavanderia Cledmir", "Av. faucett", 10f,"cledmir@gmail.com", "Callao", 985654123))
        laundries.add(Laundry("Aqui lavamos bien", "Av. Universitaria", 8f,"alavamaos@gmail.com", "Cercado de Lima", 990587526))
    }

}