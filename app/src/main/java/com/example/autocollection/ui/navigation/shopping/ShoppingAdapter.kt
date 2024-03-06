package com.example.autocollection.ui.navigation.shopping

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autocollection.R
import com.example.autocollection.data.CarItem
import com.example.autocollection.databinding.ItemCarBinding
import com.example.autocollection.ui.inflate
import com.example.autocollection.ui.loadUrl
import kotlin.properties.Delegates

class ShoppingAdapter(items:List<CarItem> = emptyList()) :
    RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

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
            carItem.let {
                binding.imageView2.loadUrl(carItem.url?:R.string.not_found.toString(),false)
                binding.marca.text = carItem.marca
                binding.modelo.text = carItem.modelo.toString()
            }
        }
    }
}