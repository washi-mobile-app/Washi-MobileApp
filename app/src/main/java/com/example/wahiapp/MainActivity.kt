package com.example.wahiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(order: Order) {
        val intent = Intent(this, OrderDetail::class.java)
        startActivity(intent)

        val message = intent.getStringExtra("order")

        val textView = findViewById<TextView>(R.id.tvLaundryName).apply {
            text = message
        }
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

        orders.add(Order("Lavandería Don Pepe", "S/. 44.60", "En camino"))
        orders.add(Order("Lavandería Don Pepe", "S/. 30.50", "En camino"))
        orders.add(Order("Lavandería Don Pepe", "S/. 35.00", "Entregado"))
    }

}