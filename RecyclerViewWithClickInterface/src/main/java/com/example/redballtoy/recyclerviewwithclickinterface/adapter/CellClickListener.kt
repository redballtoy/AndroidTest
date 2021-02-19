package com.example.redballtoy.recyclerviewwithclickinterface.adapter

import com.example.redballtoy.recyclerviewwithclickinterface.model.Model

//https://medium.com/@aayushpuranik/recycler-view-using-kotlin-with-click-listener-46e7884eaf59

interface CellClickListener {
    fun setOnClickListener(data: Model)
}