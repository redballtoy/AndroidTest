package com.example.redballtoy.mvpatternsotus.mvp.presenter

import com.example.redballtoy.mvpatternsotus.mvp.model.MainRepository
import com.example.redballtoy.mvpatternsotus.mvp.view.MainView

class MainPresenterImpl(
        val view: MainView,
        val repository: MainRepository
):MainPresenter {
    override fun onViewCreated() {
        view.setDate("NoDate")
    }

    override fun onDateClicked() {
        repository.getCurrentDateFormatted{
            result: String->
            view.setDate(result)
        }
    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

}