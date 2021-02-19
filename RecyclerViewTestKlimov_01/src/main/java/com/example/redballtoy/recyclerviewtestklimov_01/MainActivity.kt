package com.example.redballtoy.recyclerviewtestklimov_01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), OnCoteClick {

    lateinit var coteList: RecyclerView
    lateinit var coteAdapter: CustomRecyclerAdapter
    lateinit var coteData : List<CoteItem.CoteItemOne>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coteList=findViewById(R.id.rv_cote_list)
        coteData=CoteItem().getCoteList()
        val linearLayoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        coteList.layoutManager=linearLayoutManager
        coteAdapter= CustomRecyclerAdapter(this,coteData,this)
        coteList.adapter=coteAdapter


    }

    override fun onCoteClick(data: CoteItem.CoteItemOne) {
        val intent = Intent(this,BigFotoCote::class.java)
        intent.putExtra("imageId", data.getFotoId())
        startActivity(intent)
    }

}