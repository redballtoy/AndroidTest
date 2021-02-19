package com.example.redballtoy.recyclerviewanimate_touristtour

import TourAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewanimate_touristtour.custom_zoom_class.CenterZoomLayout
import com.example.redballtoy.recyclerviewanimate_touristtour.model.Places

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init views
        val rvTour = findViewById<RecyclerView>(R.id.rv_view)

        //init layout manager here
        val layoutManager = CenterZoomLayout(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        rvTour.layoutManager = layoutManager

        //To auto Center views
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rvTour)
        rvTour.isNestedScrollingEnabled = false

        //add items to array list
        val places = ArrayList<Places>()
        places.add(Places(
                "Los Angeles",
                "Los Angeles is a southern California city and the center of" +
                        " nation's film & television industry",
                4.5f,
                "https://images.unsplash.com/photo-1503891450247-ee5f8ec46dc3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
        ))
                places.add(Places(
                "China",
                "China, Officially the people's republic of China," +
                        "it has population around 1.42 Billion in 2007",
                4.0f,
                "https://images.unsplash.com/photo-1529921879218-f99546d03a9d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80"
        ))

        places.add(Places(
                "India",
                "India is the second largest population in the world" +
                        " it is most visited country in the world",
                3.6f,
                "https://images.unsplash.com/photo-1532664189809-02133fee698d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80"
        ))

        places.add(Places(
                "Russia",
                "Russia is the largest country in the world, the ninth-most populous " +
                        "country, as well as the most populous country in Europe.",
                3.8f,
                "https://images.unsplash.com/photo-1570720742937-423ec1d7a3e0?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=562&q=80"
        ))

        //add array list to recycler view
        rvTour.adapter= TourAdapter(this,places)



    }
}