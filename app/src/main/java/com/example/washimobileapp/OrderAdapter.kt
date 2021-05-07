package com.example.washimobileapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.wahiapp.R
import com.example.washimobileapp.entities.Order

class OrderAdapter(var orders: ArrayList<Order>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<OrderPrototype> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderPrototype {
        //con esto cada elemento se inflara en un prototype y se mostrar en el recycle view
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_orders, parent, false)
        return OrderPrototype(view)
    }

    //crea un vinculo entre el adpater y de donde jala la informacion, en este caso de contacts
    override fun onBindViewHolder(holder: OrderPrototype, position: Int) {
        holder.bind(orders.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return orders.size
    }


}

class OrderPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvLaundryName = itemView.findViewById<TextView>(R.id.tvLaundryName)
    val tvLaundryCost = itemView.findViewById<TextView>(R.id.tvLaundryCost)
    val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)
    val cvOrder = itemView.findViewById<CardView>(R.id.cvOrder)

    fun bind(order: Order, itemClickListener: OnItemClickListener) {
        tvLaundryName.text = order.laundryName
        tvLaundryCost.text = order.cost
        tvStatus.text = order.status
        cvOrder.setOnClickListener {
            itemClickListener.OnItemClicked(order)
        }
    }
}

interface OnItemClickListener {
    fun OnItemClicked(order: Order)
}