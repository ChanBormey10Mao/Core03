package com.assignment.core03_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityListAdapter() : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.city_layout/*New Layout for displaying*/, parent, false) as View
        return ViewHolder(view)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v){
       private var city = v.findViewById<TextView>(R.id.city)
       private var timeZone = v.findViewById<TextView>(R.id.timeZone)
       private var heart = v.findViewById<ImageView>(R.id.notFavYet)

        fun bind(item: city){
            city.text = item.name
            timeZone.text = item.timeZone
            var fav = v.context.resources.getIdentifier("ic_baseline_favorite_24", "drawable",v.context.packageName)
            var NotFav = v.context.resources.getIdentifier("ic_baseline_favorite_border_24", "drawable",v.context.packageName)
            when (item.timeZone){
                "Australia/Melbourne" -> {
                    heart.setImageResource(fav)
                }
                else ->{
                    heart.setImageResource(NotFav)
                }
            }

        }
    }

    override fun getItemCount(): Int = CityObjectLists.count

    override fun onBindViewHolder(holder: CityListAdapter.ViewHolder, position: Int) {
        val item = CityObjectLists.cities.get(position)
        holder.bind(item)
    }

}