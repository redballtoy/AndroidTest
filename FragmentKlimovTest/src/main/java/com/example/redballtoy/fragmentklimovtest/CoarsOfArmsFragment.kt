package com.example.redballtoy.fragmentklimovtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener

class CoarsOfArmsFragment : Fragment(), FragmentResultListener {

    val KEY_INDEX = "index"
    val REQUEST_KEY = "requestKey"
    var index =2



    //метод который получает параметры которые хотим передать во фрашмент
    fun newInstance(index: Int):Fragment{
        var arguments = Bundle()
        arguments.putInt(KEY_INDEX, index)
        val fragment =CoarsOfArmsFragment()
        fragment.setArguments(arguments)
        return fragment
    }


    //создаем вью из файла разметки
    override fun onCreateView(
        inflater: LayoutInflater, //позволяет построить нужный макет считывя его из файла разметки
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("myLog", "CoarsOfArmsFragment savedInstanceState: $index ")


        return inflater.inflate(R.layout.coats_of_arms_of_cities, container, false)
    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        setFragmentResultListener(REQUEST_KEY){KEY_INDEX, result->
            index = result.getInt(KEY_INDEX)

        }
    }

}