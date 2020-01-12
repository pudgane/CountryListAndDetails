package com.pudagane.countrylist.adapters

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pudagane.countrylist.R
import com.pudagane.countrylist.model.Country
import java.util.ArrayList
import android.widget.ImageView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.pudagane.countrylist.interfaces.OnItemClickListener


class CountriesAdapter(val items : ArrayList<Country>,
                       val context: Context,
                       val itemClickListener: OnItemClickListener)
    :  RecyclerView.Adapter<CountriesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_list_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CountriesAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position],context,itemClickListener,position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(dataObj: Country,context: Context,clickListener: OnItemClickListener,position: Int) {

            val countryNmae = itemView.findViewById(R.id.name) as TextView
            val countryCapital = itemView.findViewById(R.id.capital) as TextView
            val imageView = itemView.findViewById(R.id.image) as ImageView
            Log.d("CountriesAdapter","dataObj.flag="+dataObj.flag)
            countryNmae.text = dataObj.name
            countryCapital.text = dataObj.capital

            GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse( dataObj.flag), imageView)

            itemView.setOnClickListener {
                clickListener.onItemClickPosition(position)
            }
        }


    }
}