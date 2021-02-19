package com.example.redballtoy.recyclerviewwithclickinterface.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewwithclickinterface.R
import com.example.redballtoy.recyclerviewwithclickinterface.adapter.CellClickListener
import com.example.redballtoy.recyclerviewwithclickinterface.adapter.MyAdapter
import com.example.redballtoy.recyclerviewwithclickinterface.model.Model

class GridLayoutRecyclerView : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.rv_item_list)
        //2 количество итемсов в ячейке (в два ряда будут)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MyAdapter(this, fetchList(), R.layout.cell_view_linear,this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))


    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()
        for (i in 0..13) {
            val model = Model(
                    R.drawable.cherry,
                    "Title: $i",
                    "Subtitle: $i"
            )
            list.add(model)
        }
        return list
    }

    override fun setOnClickListener(data: Model) {
        Toast.makeText(this,"${data.title}, ${data.subtitle}", Toast.LENGTH_SHORT).show()
    }


}
