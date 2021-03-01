package com.example.redballtoy.fragmenttofragmentcommunication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SelectorFragment : Fragment() {

    private val TAG = "Selector Fragment"
    private lateinit var iMainActivity: IMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iMainActivity.setToolbarTitle(TAG)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmant_selector, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iMainActivity = activity as IMainActivity
        //iMainActivity=context as IMainActivity
     }


}