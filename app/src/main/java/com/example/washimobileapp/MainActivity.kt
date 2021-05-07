package com.example.washimobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wahiapp.R
import com.example.washimobileapp.entities.Order
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(order: Order) {
        val intent = Intent(this, OrderDetail::class.java)
        val gson = Gson()
        intent.putExtra("order", gson.toJson(order))
        startActivity(intent)

    }

    var orders = ArrayList<Order>()
    var orderAdapter = OrderAdapter(orders, this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadOrders()
        initView()
    }

    private fun initView() {
        val rvPedidos = findViewById<RecyclerView>(R.id.rvPedidos)
        rvPedidos.adapter = orderAdapter
        rvPedidos.layoutManager = LinearLayoutManager(this)
    }

    private fun loadOrders() {

        orders.add(Order("Lavandería Don Pepe", "S/. 44.60", "En camino", "05/05/21", "08/05/21"))
        orders.add(Order("Lavandería Don Pepe", "S/. 30.50", "En camino", "06/06/21", "08/05/21"))
        orders.add(Order("Lavandería Don Pepe", "S/. 35.00", "Entregado", "28/04/21", "02/05/21"))
    }

}