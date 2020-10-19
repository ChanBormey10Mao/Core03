package com.assignment.core03_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var CityList = findViewById<RecyclerView>(R.id.CityList)

        CityList.adapter = CityListAdapter()
        CityList.layoutManager= LinearLayoutManager(this)
    }
}