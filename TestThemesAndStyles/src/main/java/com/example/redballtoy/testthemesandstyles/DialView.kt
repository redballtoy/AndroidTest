package com.example.redballtoy.testthemesandstyles

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.content.withStyledAttributes
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

//Названия меток на индикаторе
private enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);

    //Добавление перебора при клике
    fun next() = when (this) {
        OFF -> LOW
        LOW -> MEDIUM
        MEDIUM -> HIGH
        HIGH -> OFF
    }


}

//Константы для рисования индикатора и меток
private const val RADIUS_OFFSET_LABEL = 30
private const val RADIUS_OFFSET_INDICATOR = -35


/*
* Создание пользовательской вьюхи с нуля (используя наследование от View)
* рисование надо определять самстоятельно переопределяя методы:
    - onSizeChanged () - изменение размера вьюшки при каждой ее перерисовке
    - onDraw() - рисование вьюшки с использованием Canvas в стиле заданном в Paint,
        вызывается всякий раз при перерисовке экрана, его надо нагружать и вызывать как можно меньше
        - не размещать в нем allocations поскольку применение при кликах сборщика мусора
        может привести к визуальному заиканию
    - invalidate() - вызывается при клике на вьюшке что бы onDraw() перерисовал ее
 */

class DialView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    /*Эти значения создаются и инициализируются здесь, а не тогда когда фактически отрисовываются
    * что бы гарантировать что фвктический шаг отрисовки выполняется как можно быстрее
    */
    private var radius = 0.0f //текущий радиус круга, он устанавливается когда вью выводится на экран
    private var fanSpeed = FanSpeed.OFF //текущий уроыень регулировки, по умолчанию OFF


    //переменная определяющая позицию которая будет использоваться для рисования метки и индикатора
    //на круге
    private val pointPosition: PointF = PointF(0.0f, 0.0f)

    //инициализация Paint объекта с помощью нескольких основных стилей
    //инициализация здесь так же происходит для ускорения этапа прорисовки
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    //Добавляеи атрибуты цветов которые задали в att.xml и добавили во вьюшку в основном шаблоне
    private var fanSpeedLowColor = 0
    private var fanSpeedMediumColor = 0
    private var fanSpeedMaxColor = 0

    //Блок инициализации
    init {
        //Инициализация кликабельности у вьюшки после добавления ее в шаблон
        isClickable = true

        //Добавление extension function которая импортирует правильную функцию getColor()
        //эта функция расширяет библиотеку android-ktx
        context.withStyledAttributes(attrs, R.styleable.DialView) {
            fanSpeedLowColor = getColor(R.styleable.DialView_fanColor1, 0)
            fanSpeedMediumColor = getColor(R.styleable.DialView_fanColor2, 0)
            fanSpeedMaxColor = getColor(R.styleable.DialView_fanColor3, 0)

            //Добавляем инициализацию функции для людей с ограниченными возможностями
            //при нажатии на заголовок его название будет проговариваться
            //https://developer.android.com/codelabs/advanced-andoid-kotlin-training-custom-views#8
            updateContentDesctiption()

            //Для еще большего развития функционала Доступности для людей с ограниченными
            //возможностями используется делегат AccessibilityDelegateCompat из библиотеки
            //androidx.core.view.ViewCompat что позволяет так же обеспечить обратную
            //совместимость
            /* Каждое представление имеет дерево узлов доступности, которые могут соответствовать
                или не соответствовать фактическим компонентам макета представления.
                Службы специальных возможностей Android перемещаются по этим узлам, чтобы найти
                информацию о представлении (такую как описания произносимого содержимого или
                возможные действия, которые могут быть выполнены в этом представлении).
                При создании настраиваемого представления вам также может потребоваться
                переопределить информацию об узлах в чтобы предоставить специальную информацию
                для доступности. В этом случае вы переопределите информацию об узле, чтобы указать,
                что есть настраиваемая информация для действия представления.
                https://developer.android.com/codelabs/advanced-andoid-kotlin-training-custom-views#8
            */
            ViewCompat.setAccessibilityDelegate(this@DialView, object : AccessibilityDelegateCompat() {
                override fun onInitializeAccessibilityNodeInfo(host: View?,
                                                               info: AccessibilityNodeInfoCompat?) {
                    super.onInitializeAccessibilityNodeInfo(host, info)
                    val customClick = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                            AccessibilityNodeInfo.ACTION_CLICK,
                            //"placeholder"
                            /*Класс AccessibilityActionCompat представляет действие в представлении для
                                целей доступности. Типичное действие - это щелчок или касание, как вы
                                здесь используете, но другие действия могут включать получение или
                                потерю фокуса, операцию с буфером обмена (вырезать / копировать / вставить)
                                или прокрутку в представлении. Конструктору этого класса требуется
                                константа действия (здесь AccessibilityNodeInfo.ACTION_CLICK) и строка,
                                которая используется TalkBack, чтобы указать, что это за действие.
                                Замените строку «заполнитель» вызовом context.getString () для получения
                                строкового ресурса.
                            */
                            context.getString(if (fanSpeed != FanSpeed.HIGH)
                                R.string.change else R.string.reset
                            )
                    )
                }
            })

        }


    }

    //Переопределение метода для реализации кликов (так же добавляется после добавления в )
    //шаблон
    /* Обычно стандартная View реализует  OnClickListener(), для custom view взамен этого
        метода необходимо реализовать метод performClick() и вызвать super.performClick()
        по умолчанию performClick() вызываеи  так же и OnClickListener() но всю логику
        по работе вью нужно описать в performClick()  а метод OnClickListener() оставить
        для внешних разработчиков которые будут пользоваться вьюшкой
    *
    * */
    override fun performClick(): Boolean {
        //должен быть вызван в начале что бы вселючить доступность событий и что бы можно
        //было вызвать OnClickListener()
        if (super.performClick()) return true
        //перебираем при каждом нажатии
        fanSpeed = fanSpeed.next()
        contentDescription = resources.getString(fanSpeed.label)
        //Точно так же как в init добавляем функцию проговаривания для людей с
        //ограниченными возможностями при нажатии на круг
        updateContentDesctiption()
        invalidate()
        return true
    }

    //Переопределение методов View
    //метод onSizeChanged используется при определении размеров вьюшки при первых и последующих
    //запусках, в данном случае рассчитываем радиус циферблата
    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (kotlin.math.min(width, height) / 2.0 * 0.8).toFloat()
    }

    //функция computeXYForSpeed()  расширяющая класс PointF, она вычисляет координаты XY
    //для тексторовой метки текущего индикатора (0,1,2,3) с учетом текущего положения FanSpeed
    //и радиуса круга, это будет использоваться в onDraw()
    private fun PointF.computeXYForSpeed(pos: FanSpeed, radius: Float) {
        //Углы рассчитаны в радианах
        val startAngle = Math.PI * (9 / 8.9)
        val angle = startAngle + pos.ordinal * (Math.PI / 4)
        x = (radius * kotlin.math.cos(angle)).toFloat() + width / 2
        y = (radius * kotlin.math.sin(angle)).toFloat() + height / 2
    }

    //Визуализирует вьюшку вместе с Canvas и Paint классами
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //Устанавливаем цвет вращающейся ручки в зависимсти от положения
        //paint.color = if(fanSpeed==FanSpeed.OFF) Color.GRAY else Color.LTGRAY
        //Замена на дополнительную фичу изменение цвета в зависимости от установленной скорости
        paint.color = when (fanSpeed) {
            FanSpeed.OFF -> Color.GRAY
            FanSpeed.LOW -> fanSpeedLowColor
            FanSpeed.MEDIUM -> fanSpeedMediumColor
            FanSpeed.HIGH -> fanSpeedMaxColor
        }

        //Рисование круга
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
        //Добавление маленького круга который является индикатором положения
        val markerRadius = radius + RADIUS_OFFSET_INDICATOR
        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)
        paint.color = if (fanSpeed == FanSpeed.OFF) Color.BLACK else Color.BLUE
        canvas.drawCircle(pointPosition.x, pointPosition.y, radius / 12, paint)
        //Добавление самих меток скорости
        val labelRadius = radius + RADIUS_OFFSET_LABEL
        for (i in FanSpeed.values()) {
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            paint.color = Color.BLACK //цвет меток
            canvas.drawText(label, pointPosition.x, pointPosition.y, paint)
        }
        //После этого добавляем View в Layout
    }

    //В конце добавляем функию дублирования для людей с ограниченными возможностями
    //Settings > Accessibility > TalkBack.
    fun updateContentDesctiption() {
        contentDescription = resources.getString(fanSpeed.label)

    }
}