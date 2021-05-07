package com.example.washimobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.wahiapp.R
import com.example.washimobileapp.entities.Order
import com.google.gson.Gson

class OrderDetail : AppCompatActivity() {
    lateinit var order: Order
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        loadOrder()

    }
    fun goBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    fun loadOrder() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("order")

        order = gson.fromJson(stringObj, Order::class.java) ?: Order("", "", "", "", "")

        if (order.laundryName != null)
        {
            val tvNombreD = findViewById<TextView>(R.id.tvNombreD)
            val tvFechaD = findViewById<TextView>(R.id.tvFechaD)
            val tvFechaEntregaD = findViewById<TextView>(R.id.tvFechaEntregaD)
            val tvEstadoD = findViewById<TextView>(R.id.tvEstadoD)
            val tvCostoD = findViewById<TextView>(R.id.tvCostoD)

            tvNombreD.setText(order.laundryName)
            tvFechaD.setText(order.date)
            tvFechaEntregaD.setText(order.deliveryDate)
            tvEstadoD.setText(order.status)
            tvCostoD.setText(order.cost)
        }
    }


}