package com.washi.washi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.prototype_laundry_card.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    var laundries = ArrayList<Laundry>()
    var laundriesToShow = ArrayList<Laundry>()
    var laundryAdapter = LaundryAdapter(laundriesToShow)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLaundries()
        initView()

        cvLaundryCard.setOnClickListener() {
            val intent = Intent(this, SearchLaundriesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        rvLaundries.adapter = laundryAdapter
        rvLaundries.layoutManager = LinearLayoutManager(this)
    }

    private fun loadLaundries() {
        laundries.add(Laundry("Lavanderia Akiraki", "Av. La marina", 9.99f, "akira@gmail.com", "San Miguel", 958158852))
        laundries.add(Laundry("Lavanderia Cledmir", "Av. faucett", 10f,"cledmir@gmail.com", "Callao", 985654123))
        laundries.add(Laundry("Aqui lavamos bien", "Av. Universitaria", 8f,"alavamaos@gmail.com", "Cercado de Lima", 990587526))

        laundriesToShow.addAll(laundries.filterNotNull())
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == Activity.RESULT_OK) {
                val name = data!!.getStringExtra("name")
                val address = data!!.getStringExtra("address")
                val price = data!!.getStringExtra("price")

                laundriesToShow.clear()
                if (name.isNullOrEmpty() && address.isNullOrEmpty() && price.isNullOrEmpty()) {
                    laundriesToShow.addAll(laundries.filterNotNull())
                }
                else {
                    for (laundry in laundries) {
                        if (laundry.name?.contains(name!!, ignoreCase = true) == true ||
                            laundry.address?.contains(address!!, ignoreCase = true) == true ||
                            laundry.price == price!!.toFloat()
                        ) {
                            laundriesToShow.add(laundry)
                        }
                    }
                }
            }
        }
    }
}