package com.example.redballtoy.viewandlayouts_androidacademy_02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Frame Layout
            //чем дальше вниз расположена вьшка по текту XML тем "ближе" она к нам
        //setContentView(R.layout.frame_layout)

        //scrollView
            //позволяет вкладывать в себя либо только один View либо один контейнер
        //setContentView(R.layout.linear_layout_scroll)

        //Linear layout weight
            //указывает как много пространства должна занимать вьюха,
            // по умолчанию weigh=0, для этого наприемер высота устанавливается
            //в 0dp что означает что мы не хотим контроливать этот размер
            //затем устанавливаем используемую долю применив weight
            //что бы ускорить расчет общего веса можно задать его в коренном
            //для этих элементов шаблоне
        //setContentView(R.layout.linear_layout_weight)

        //Linear Layout gravity
            //обязательно должна быть указана ориентация шаблона
            //setContentView(R.layout.linear_layout_gravity)
            //все в одном Workshop 2
        //setContentView(R.layout.view_and_view_group_workshop)

        //Relative Layout
            //позволяет позиционировать вьюшки друг относительно друга
            //так же как и во FrameLayout позволяет накладывать вьюшку на другую (так же по
            // z-ordering - чем ниже по файлу разметки расположено тем ближе к нам!)
        //setContentView(R.layout.relative_layout_common)

        //Constraint Layout
            //пришел на смену Relative Layout и представляет собой плоскую иерархию
                //вьюшек - flat view hirarchy
            //Barrier - является гибким, его расположение может измениться при
                //изменении размера вьюшки. В XML в нем указываются id вьюшек
            //Guideline - фиксированная позиция, они не от кого не зависят, это
                //от них зависит положение вью
        //setContentView(R.layout.constraint_layout)

            //Chains
                //Цепочка - это когда создаются двойные констрейны между двумя вьюшками
                // При изменении visible на
                        //invisible - вьюшка продолжает отрисовываться в макете
                            //но становится невидимой
                        //gone - вьюшка не отрисовывается и сжимается в точку,
                            //при этом меняется расположение связанных с ней вьюшек
                            //так словно этой вьюшки нет в разметке

            setContentView(R.layout.chains_layout)






    }
}