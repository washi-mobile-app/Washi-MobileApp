package com.washi.washi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    var laundries = ArrayList<Laundry>()
    var laundriesToShow = ArrayList<Laundry>()
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

        laundriesToShow = laundries
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemSearch -> {
                val intent = Intent(this, SearchLaundriesActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}