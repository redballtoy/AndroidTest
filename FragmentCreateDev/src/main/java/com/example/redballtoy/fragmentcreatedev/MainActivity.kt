package com.example.redballtoy.fragmentcreatedev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private val  KEY_INT = "key_int"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add Fragment_B using code
        if (savedInstanceState == null) {
            val  bundle = bundleOf(KEY_INT to 0)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentB>(R.id.fc_container_for_fragment_b)
            }
        }


    }
}