package com.example.redballtoy.mvpatternsotus.mvp.model

interface MainRepository {
    fun getCurrentDateFormatted(callback: (String) -> Unit)

}