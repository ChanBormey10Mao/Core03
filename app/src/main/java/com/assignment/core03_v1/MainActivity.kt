package com.assignment.core03_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

var cities = mutableListOf<city>()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var CityList = findViewById<RecyclerView>(R.id.CityList)
        CityList.layoutManager= LinearLayoutManager(this)



        resources.openRawResource(R.raw.au_locations).bufferedReader()
            .forEachLine {
                var temp = it.split(",")
                cities.add(city(temp[0].toString(),temp[1].toDouble(),temp[2].toDouble(),temp[3].toString()))
            }
//        cities.forEach{
//            Log.i("FILENAME", "${it.timeZone}")
//        }
        Log.i("FILENAME", "${cities.size}")

        CityList.adapter = CityListAdapter(cities)


    }
}