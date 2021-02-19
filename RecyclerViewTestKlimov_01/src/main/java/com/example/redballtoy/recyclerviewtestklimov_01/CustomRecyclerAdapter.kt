package com.example.redballtoy.recyclerviewtestklimov_01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(
    private val context: Context,
    private val list: List<CoteItem.CoteItemOne>,
    private val onCoteClick: OnCoteClick
) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: CustomRecyclerAdapter.MyViewHolder, position: Int) {
        val data = list[position]
        holder.fotoCote.setImageDrawable(ContextCompat.getDrawable(context, data.getFotoId()))
        holder.aboutCote.setText(data.getTextId())
        holder.itemView.setOnClickListener {
            onCoteClick.onCoteClick(data)
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoCote: ImageView = itemView.findViewById(R.id.iv_cote_foto)
        val aboutCote: TextView = itemView.findViewById(R.id.tv_about_cote)

    }
}