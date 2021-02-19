package com.example.redballtoy.activitycommon_androidacademy_01

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TRANSMITTED_STRING = "transmittedString"
        const val TRANSMITTED_INT = "transmittedInt"
        const val TRANSMITTED_BOOLEAN = "transmittedBoolean"
        const val REQUEST_CODE_SECOND_ACTIVITY = 0
    }

    lateinit var tvGoSecomdActivity: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(R.layout.activity_second)
        //инициализация переменной TextView как кнопки перехода
        tvGoSecomdActivity = findViewById(R.id.tv_go_to_third_activity)
        //Добавление обработчика нажатия кнопки
        tvGoSecomdActivity.setOnClickListener { moveToNextActivity() }
    }

    private fun moveToNextActivity() {
        val intent = Intent(this, ThirdActivity::class.java)

        //Добавление данных в интент
        val transmittedString = "string to transmit"
        intent.putExtra(TRANSMITTED_STRING, transmittedString)

        val trasmittedInt = 12
        intent.putExtra(TRANSMITTED_INT, trasmittedInt)

        val trasmittedBoolean = true
        intent.putExtra(TRANSMITTED_BOOLEAN, trasmittedBoolean)

        //startActivity(intent)
        startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                tvGoSecomdActivity.text = (getText(R.string.get_back_params).toString()
                        + "\nTRANSMITTED_STRING = ${data?.getStringExtra(TRANSMITTED_STRING)}"
                        + "\nTRANSMITTED_INT = ${data?.getIntExtra(TRANSMITTED_INT, 0)}"
                        + "\nTRANSMITTED_BOOLEAN = ${
                    data?.getBooleanExtra(
                        TRANSMITTED_BOOLEAN,
                        false
                    )
                }")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}