package com.example.redballtoy.activitycommon_androidacademy_01

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    companion object {
        const val TRANSMITTED_STRING = "transmittedString"
        const val TRANSMITTED_INT = "transmittedInt"
        const val TRANSMITTED_BOOLEAN = "transmittedBoolean"
        const val MY_LOG = "myLog"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val transmittedString: String? = intent.getStringExtra(TRANSMITTED_STRING)
        val transmittedInt: Int? = intent.getIntExtra(TRANSMITTED_INT, -1)
        val transmittedBoolean: Boolean? = intent.getBooleanExtra(TRANSMITTED_BOOLEAN, false)

        //Выведем переданные значения
        val tvShowParam = findViewById<TextView>(R.id.tv_show_param_act_3)
        tvShowParam.text = "${getString(R.string.these_values_passed_from_second_activity)}" +
                "\ntransmittedString = $transmittedString" +
                "\ntransmittedInt = $transmittedInt" +
                "\ntransmittedBoolean = $transmittedBoolean"

        val uriOpen = "https://lenta.ru/"
        val tvOpenBrowser = findViewById<TextView>(R.id.tv_open_browser)
        tvOpenBrowser.setOnClickListener { openBrowser(uriOpen) }

        //Логирование
        Log.d(MY_LOG, "onCreate")
    }

    private fun openBrowser(uriOpen: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriOpen))
        startActivity(intent)
        Log.d(MY_LOG, "openBrowser: Browser Started")
    }

    override fun onStop() {
        super.onStop()
        setResult(RESULT_OK, intent)
        finish()
        Log.d(MY_LOG, "onStop:")
        Toast.makeText(this, "Third Activity Closed!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(MY_LOG, "onPause:")
    }

    override fun onStart() {
        super.onStart()
        Log.d(MY_LOG, "onStart:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MY_LOG, "onDestroy:")
    }
}