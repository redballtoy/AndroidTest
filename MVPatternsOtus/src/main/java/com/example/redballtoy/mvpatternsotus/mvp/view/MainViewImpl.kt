package com.example.redballtoy.mvpatternsotus.mvp.view

import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.example.redballtoy.mvpatternsotus.R
import com.example.redballtoy.mvpatternsotus.mvp.presenter.MainPresenter

class MainViewImpl(
        val rootView: View
        ) : MainView {
    lateinit var presenter: MainPresenter
    lateinit var tvHeader: TextView
    lateinit var spChoiser: Spinner
    lateinit var ivShowPatterns: ImageView


    fun onFinishInflate(presenter: MainPresenter) {
        this.presenter = presenter
        tvHeader = rootView.findViewById(R.id.tvHeader)
        tvHeader.isClickable
        spChoiser = rootView.findViewById(R.id.spChoiser)
        ivShowPatterns = rootView.findViewById(R.id.ivShowPatterns)

        tvHeader.setOnClickListener {
            presenter.onDateClicked()
        }
    }

    override fun setDate(date: String) {
        tvHeader.text = date
    }
}