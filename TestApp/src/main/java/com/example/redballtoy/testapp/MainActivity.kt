package com.example.redballtoy.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btShowText : Button = findViewById(R.id.bt_show_text)
        btShowText.setOnClickListener {
            val etInputText: EditText = findViewById(R.id.et_input_text)
            val tvShowText: TextView = findViewById(R.id.tv_show_edit)
            tvShowText.text = etInputText.text.toString()

        }


    }
}