package com.example.redballtoy.recyclerviewwithclickinterface

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.redballtoy.recyclerviewwithclickinterface.view.CardViewRecyclerView
import com.example.redballtoy.recyclerviewwithclickinterface.view.GridLayoutRecyclerView
import com.example.redballtoy.recyclerviewwithclickinterface.view.LinearLayoutRecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btLinearLayout: Button = findViewById(R.id.bt_linear)
        val btCardView: Button = findViewById(R.id.bt_card_view)
        val btGridLayout: Button = findViewById(R.id.bt_grid_layout)
        btLinearLayout.setOnClickListener(this)
        btCardView.setOnClickListener(this)
        btGridLayout.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        var intent: Intent? = null
        when (v.id) {

            R.id.bt_linear -> intent =
                Intent(this, LinearLayoutRecyclerView::class.java)
            R.id.bt_card_view -> intent =
                Intent(this, CardViewRecyclerView::class.java)
            R.id.bt_grid_layout -> intent =
                Intent(this, GridLayoutRecyclerView::class.java)
        }
        startActivity(intent)
    }
}