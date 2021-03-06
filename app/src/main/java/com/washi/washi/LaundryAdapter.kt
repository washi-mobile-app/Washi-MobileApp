package com.washi.washi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.washi.washi.entities.Laundry
import kotlinx.android.synthetic.main.prototype_laundry_card.view.*

class LaundryAdapter(var laundries: ArrayList<Laundry>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<LaundryPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_laundry_card, parent, false)

        return  LaundryPrototype(view)
    }

    override fun onBindViewHolder(contactPrototype: LaundryPrototype, position: Int) {
        contactPrototype.bind(laundries.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return laundries.size
    }
}

class LaundryPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvLaundryName
    val tvAddress = itemView.tvLaundryAddress
    val tvPrice = itemView.tvLaundryPrice
    val btViewLaundry = itemView.btViewLaundry

    fun bind(laundry: Laundry, itemClickListener: OnItemClickListener){
        tvName.text = laundry.name
        tvAddress.text = laundry.address
        tvPrice.text = "S/. " + laundry.price.toString() + " x Kg"
        btViewLaundry.setOnClickListener {
            itemClickListener.OnItemClicked(laundry)
        }
    }
}

interface OnItemClickListener{
    fun OnItemClicked(laundry: Laundry)
}