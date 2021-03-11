package com.example.redballtoy.fragmentklimovtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class CityFragment : Fragment(), View.OnClickListener{


    val KEY_INDEX: String = "index"
    val REQUEST_KEY: String = "requestKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //добавляем разметку фрагмента к фрагменту
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.city_fragment, container, false)

        val btMsc: Button = rootView.findViewById(R.id.bt_show_msc)
        val btEkb: Button = rootView.findViewById(R.id.bt_show_ebrg)
        val btSpb: Button = rootView.findViewById(R.id.bt_show_spb)
        val btNor: Button = rootView.findViewById(R.id.bt_show_nsk)
        val btSam: Button = rootView.findViewById(R.id.bt_show_sam)

        btMsc.setOnClickListener(this)
        btEkb.setOnClickListener(this)
        btSpb.setOnClickListener(this)
        btNor.setOnClickListener(this)
        btSam.setOnClickListener(this)

        return rootView
    }

    override fun onClick(v: View?) {
        var index: Int = -1
        when (v?.id) {
            R.id.bt_show_msc -> index = 1
            R.id.bt_show_ebrg -> index = 2
            R.id.bt_show_spb -> index = 3
            R.id.bt_show_nsk -> index = 4
            R.id.bt_show_sam -> index = 5
        }
        Toast.makeText(v?.context, "$index", Toast.LENGTH_SHORT).show()

        setFragmentResult(REQUEST_KEY, bundleOf(KEY_INDEX to index))

    }
}
