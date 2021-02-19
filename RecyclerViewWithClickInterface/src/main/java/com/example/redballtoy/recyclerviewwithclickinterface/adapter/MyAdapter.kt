package com.example.redballtoy.recyclerviewwithclickinterface.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewwithclickinterface.R
import com.example.redballtoy.recyclerviewwithclickinterface.model.Model

class MyAdapter(
    private val context: Context,
    private val list: ArrayList<Model>,
    private val cellItemId :Int,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val iconTV = view.findViewById<ImageView>(R.id.iv_logo)
        val titleTV = view.findViewById<TextView>(R.id.tv_title)
        val subtitleTV = view.findViewById<TextView>(R.id.tv_sub_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewCell = LayoutInflater.from(context)
            .inflate(cellItemId, parent, false)
        return MyViewHolder(viewCell)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.iconTV.setImageDrawable(ContextCompat.getDrawable(context, data.icon))
        holder.titleTV.text = data.title
        holder.subtitleTV.text = data.subtitle
        holder.itemView.setOnClickListener {
            cellClickListener.setOnClickListener(data)
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }


}


