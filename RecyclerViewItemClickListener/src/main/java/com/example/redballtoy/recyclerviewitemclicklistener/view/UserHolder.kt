package com.example.redballtoy.recyclerviewitemclicklistener.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewitemclicklistener.R
import com.example.redballtoy.recyclerviewitemclicklistener.model.User

class UserHolder(var itemView: View) : RecyclerView.ViewHolder(itemView){
    private val userItem = itemView.findViewById<View>(R.id.tvUsername) as TextView
    private val phone = itemView.findViewById<View>(R.id.tvPhone) as TextView

    fun bind(user: User,clickListener: OnItemClickListener){
        userItem.text=user.username
        phone.text=user.phone

        itemView.setOnClickListener{
            clickListener.onItemClickListener(user)
        }
    }
}