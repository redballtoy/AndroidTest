package com.example.redballtoy.z_startandroidnoub

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btToastShow: Button
    lateinit var btCount: Button
    lateinit var btRandom: Button
    lateinit var tvShowCount: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val onClickListener: View.OnClickListener = View.OnClickListener {
            when (it.id) {
                R.id.bt_toast -> {
                    toastMe(it)
                    tvShowCount.text = getText(R.string._0)
                }
                R.id.bt_count -> tvShowCount.text = getText(R.string.hello_toast)
                R.id.bt_random -> tvShowCount.text = getText(R.string.hello_toast)
            }

        }
        btToastShow.setOnClickListener(onClickListener)
        btCount.setOnClickListener(onClickListener)
        btRandom.setOnClickListener(onClickListener)


    }

    private fun initView() {
        btToastShow = findViewById(R.id.bt_toast)
        btCount = findViewById(R.id.bt_count)
        btRandom = findViewById(R.id.bt_random)
        tvShowCount = findViewById(R.id.tv_show_count)

    }

    private fun toastMe(viev: View) {
        val myToast = Toast.makeText(
            this, getString(R.string.hello_toast), Toast.LENGTH_SHORT
        )
        myToast.show()
    }

    fun countMe(view: View) {
        val counterString = tvShowCount.text.toString()
        //конвертируем полученное число и увеличиваем его на 1

    }


}