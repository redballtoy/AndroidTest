package com.example.redballtoy.recyclerviewitemclicklistener

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redballtoy.recyclerviewitemclicklistener.model.User
import com.example.redballtoy.recyclerviewitemclicklistener.view.OnItemClickListener
import com.example.redballtoy.recyclerviewitemclicklistener.view.RecyclerAdapter

//https://medium.com/android-gate/recyclerview-item-click-listener-the-right-way-daecc838fbb9

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var adapter: RecyclerAdapter

    val users = mutableListOf<User>(
        User("Ngenge Senior","1234"),
        User("Ngenge Junior","6796"),
        User("Random","908773"),
        User("Random User","908321"),
        User("Random Another","908743"),
        User("Random Man","908773"),
        User("Random","908273"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usersList = findViewById<RecyclerView>(R.id.rvUsersList)
        usersList.layoutManager= LinearLayoutManager(this)
        adapter =RecyclerAdapter(users,this)
        usersList.adapter=adapter

    }

    override fun onItemClickListener(user: User) {
        Toast.makeText(this,"User name ${user.username} \n Phone:${user.phone}", Toast.LENGTH_LONG)
        .show()
        Log.i("USER_",user.username)
    }
}