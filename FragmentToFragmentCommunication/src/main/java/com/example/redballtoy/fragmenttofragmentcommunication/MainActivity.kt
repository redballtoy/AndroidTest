package com.example.redballtoy.fragmenttofragmentcommunication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), IMainActivity {

    private val TAG = "Main Activity"
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setToolbarTitle(TAG)
    }


    private fun init(){
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.tv_toolbar_title)

        val fragment:SelectorFragment = SelectorFragment()
        doFragmentTransaction(fragment,getString(R.string.fragment_selector),false,"")
    }

    private fun doFragmentTransaction(fragment: Fragment,
                                      tag: String, addToBackStack: Boolean,message:String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container,fragment,tag)
        if (addToBackStack){
            transaction.addToBackStack(tag)
        }
        transaction.commit()

    }

    override fun setToolbarTitle(fragmentTag: String) {
        toolbarTitle.text = fragmentTag
    }


}