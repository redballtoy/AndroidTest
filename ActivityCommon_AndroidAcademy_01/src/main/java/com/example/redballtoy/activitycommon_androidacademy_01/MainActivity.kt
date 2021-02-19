package com.example.redballtoy.activitycommon_androidacademy_01

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //инициализация переменной TextView как кнопки перехода
        val tvGoSecomdActivity: TextView = findViewById(R.id.tv_go_to_second_activity)
        //Добавление обработчика нажатия кнопки
        tvGoSecomdActivity.setOnClickListener { moveToNextActivity() }
    }

    private fun moveToNextActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}