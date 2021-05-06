package com.washi.washi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var laundries = ArrayList<Laundry>()
    var laundryAdapter = LaundryAdapter(laundries)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLaundries()
        initView()
    }

    private fun initView() {
        rvLaundries.adapter = laundryAdapter
        rvLaundries.layoutManager = LinearLayoutManager(this)
    }

    private fun loadLaundries() {
        laundries.add(Laundry("Lavanderia Akiraki", "Av. La marina", 9.99f))
        laundries.add(Laundry("Lavanderia Cledmir", "Av. faucett", 10f))
        laundries.add(Laundry("Aqui lavamos bien", "Av. La marina", 8f))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }
}