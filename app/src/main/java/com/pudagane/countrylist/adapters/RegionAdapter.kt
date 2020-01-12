package com.pudagane.countrylist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pudagane.countrylist.R
import kotlinx.android.synthetic.main.continent_list_item_layout.view.*

class RegionAdapter (val items:  Array<String>, private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.continent_list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(items[position], clickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(continent: String, clickListener: (String) -> Unit) {
            itemView.name.text = continent
            itemView.setOnClickListener { clickListener(continent)}
        }
    }
}