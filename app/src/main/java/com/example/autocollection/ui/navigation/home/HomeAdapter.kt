package com.example.autocollection.ui.navigation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autocollection.R
import com.example.autocollection.data.CarItem
import com.example.autocollection.databinding.ItemCarBinding
import com.example.autocollection.ui.inflate
import com.example.autocollection.ui.loadUrl
import kotlin.properties.Delegates

class HomeAdapter(items:List<CarItem> = emptyList()) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var items :  List<CarItem> by Delegates.observable(items){_ ,_ ,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_car)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemCarBinding.bind(view)
        fun bind(carItem: CarItem){
            binding.imageView2.loadUrl(carItem.url)
            binding.marca.text = carItem.marca
            binding.modelo.text = carItem.modelo
        }
    }
}