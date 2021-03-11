package com.example.redballtoy.recyclerviewitemclicklistener.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewitemclicklistener.R
import com.example.redballtoy.recyclerviewitemclicklistener.model.User

class RecyclerAdapter(
    var usersList: MutableList<User>,
    private val itemClickListener: OnItemClickListener
    ): RecyclerView.Adapter<UserHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = usersList[position]
        holder.bind(user,itemClickListener)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }


}