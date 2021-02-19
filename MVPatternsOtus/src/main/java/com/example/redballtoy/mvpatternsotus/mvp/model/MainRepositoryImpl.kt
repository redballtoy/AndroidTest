package com.example.redballtoy.mvpatternsotus.mvp.model

import java.text.SimpleDateFormat
import java.util.*

class MainRepositoryImpl:MainRepository {
    override fun getCurrentDateFormatted(callback: (String) -> Unit) {
        val currentTime=Calendar.getInstance().time
        val dt=SimpleDateFormat("dd-mm-yyyy hh:mm:ss")
        val date=dt.format(currentTime)

        callback.invoke(date)
    }
}