package com.example.redballtoy.fragmentklimovtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class CityFragment : Fragment(), View.OnClickListener {


    //добавляем разметку фрагмента к фрагменту
    override fun onCreateView(
        inflater: LayoutInflater, //позволяет построить нужный макет считывя его из файла разметки
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
        lateinit var buttonName: String
        when (v?.id) {
            R.id.bt_show_msc -> buttonName = getString(R.string.city_name_msc)
            R.id.bt_show_ebrg -> buttonName = getString(R.string.city_name_ebrg)
            R.id.bt_show_spb -> buttonName = getString(R.string.city_name_spb)
            R.id.bt_show_nsk -> buttonName = getString(R.string.city_name_nsk)
            R.id.bt_show_sam -> buttonName = getString(R.string.city_name_sam)
        }
        Toast.makeText(v?.context, buttonName, Toast.LENGTH_SHORT).show()
    }
}
