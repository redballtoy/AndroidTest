package com.example.redballtoy.listtest_toolsshop

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar?.hide()

        val listViewTools: ListView = findViewById(R.id.lv_tools)
        listViewTools.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Нажали на позицию $position", Toast.LENGTH_SHORT).show()
            var intent: Intent
            when (position) {
                0 -> {
                    intent = Intent(this, DreelCategory::class.java).apply {}
                    startActivity(intent)
                }

                1 -> {
                }

                2 -> {
                }

            }


        }

    }
}

