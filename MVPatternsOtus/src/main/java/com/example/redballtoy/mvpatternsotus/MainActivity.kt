package com.example.redballtoy.mvpatternsotus

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.redballtoy.mvpatternsotus.mvp.model.MainRepositoryImpl
import com.example.redballtoy.mvpatternsotus.mvp.presenter.MainPresenter
import com.example.redballtoy.mvpatternsotus.mvp.presenter.MainPresenterImpl
import com.example.redballtoy.mvpatternsotus.mvp.view.MainViewImpl

class MainActivity : AppCompatActivity() {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //сначала инфлейтим root и устанавливаем ее в ContentView
        val contentView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        setContentView(contentView)

        //созданную из шаблона вьюху передаем в архитектурную вьюху
        val view = MainViewImpl(contentView)
        val repository= MainRepositoryImpl()
        presenter=MainPresenterImpl(view,repository)

        //вызываем событие onFinishInflate
        view.onFinishInflate(presenter)
        presenter.onViewCreated()

    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}