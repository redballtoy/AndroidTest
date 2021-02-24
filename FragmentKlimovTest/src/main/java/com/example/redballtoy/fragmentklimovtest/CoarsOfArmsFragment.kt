package com.example.redballtoy.fragmentklimovtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CoarsOfArmsFragment : Fragment() {

    //добавляем разметку фрагмента к фрагменту
    override fun onCreateView(
        inflater: LayoutInflater, //позволяет построить нужный макет считывя его из файла разметки
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.coats_of_arms_of_cities, container, false)
    }

}