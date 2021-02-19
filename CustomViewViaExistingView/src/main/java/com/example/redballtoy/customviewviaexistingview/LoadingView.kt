package com.example.redballtoy.customviewviaexistingview

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

/*
* Пример взят отсюда
* https://vladsonkin.com/android-custom-view-extending-the-views/
*https://vladsonkin.com/ultimate-guide-to-android-custom-view/
* Жизненный цикл View:
*   - onMeasure() - где определяется размер вьюхи
*   - onLayout() - где определяется правильная позиция в разметке
*   - onDraw() - рисование вьюхи в выбранной позиции и заданного размера
* - цель нижележащих функций перерисовать вьюшку если что то изменилось
*   - invalidate() - можно использовать для анимации в связке с ValueAnimator
*   - requestLayout() - в этой дополнительно пересчитывается размер и
*       положение вьюшки
* - для этого процесса рекомендуется сохранять макет как можно более плоским
*   что бы система могла экономить на вычислении размера
*
* */

class LoadingView : View {
    private lateinit var paint: Paint
    private var circleRadius = 50f
    private val circleFromRadius = circleRadius/5
    private var valueAnimator: ValueAnimator? = null


    //конструктор который будет использоваться из кода
    constructor(context: Context) : super(context) {
        init(context, null)
    }

    //конструктор используемый при  создании вьюшки из XML
    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)

    }

    ////onDraw вызывается много раз поэтому Paint нужно переносить
    //в другое место а не создавать снова каждый раз (например в init)
    //теперь созданный один раз paint будет повторно использоаться в
    //onDraw
    private fun init(context: Context, attrs: AttributeSet?) {
        //Paint отвечает за стиль круга
        paint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.teal_700)
            style = Paint.Style.STROKE
            strokeWidth = 10F
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //Canvas отвечает за рисование круга с помощью drawCircle
        canvas.drawCircle(width / 2f, height / 2f, circleRadius, paint)

    }

    fun showLoading() {
        isVisible = true
        //меняем circleRarius c circleFromRadius до circleRadius с интервалом в 1 секунду
        //для отрисовки каждого изменения вызываем invalidate() в addUpdateListener
        valueAnimator = ValueAnimator.ofFloat(circleFromRadius, circleRadius).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { animation ->
                circleRadius = animation.animatedValue as Float
                animation.repeatCount = ValueAnimator.INFINITE
                animation.repeatMode = ValueAnimator.REVERSE
                invalidate()
            }
            start()
        }
    }

    fun hideLoading() {
        isVisible=false
        valueAnimator?.end()
    }


}