package com.example.redballtoy.appmagicball

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var ivMagicBall: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivMagicBall = findViewById(R.id.iv_magic_ball)
        ivMagicBall.isClickable = true
        ivMagicBall.setOnClickListener {shakeBall()}



    }

    private fun shakeBall() {
        val randomChoise = getRandomChoise(20)
        val imageResource = when (randomChoise) {
            1 -> R.drawable.magic_8_ball_1
            2 -> R.drawable.magic_8_ball_2
            3 -> R.drawable.magic_8_ball_3
            4 -> R.drawable.magic_8_ball_4
            5 -> R.drawable.magic_8_ball_5
            6 -> R.drawable.magic_8_ball_6
            7 -> R.drawable.magic_8_ball_7
            8 -> R.drawable.magic_8_ball_8
            9 -> R.drawable.magic_8_ball_9
            10 -> R.drawable.magic_8_ball_10
            11 -> R.drawable.magic_8_ball_11
            12 -> R.drawable.magic_8_ball_12
            13 -> R.drawable.magic_8_ball_13
            14 -> R.drawable.magic_8_ball_14
            15 -> R.drawable.magic_8_ball_15
            16 -> R.drawable.magic_8_ball_16
            17 -> R.drawable.magic_8_ball_17
            18 -> R.drawable.magic_8_ball_18
            19 -> R.drawable.magic_8_ball_19
            20 -> R.drawable.magic_8_ball_20
            else -> R.drawable.magic_8_ball
        }
        val message = when (randomChoise) {
            1 -> R.string.magic_8_ball_1
            2 -> R.string.magic_8_ball_2
            3 -> R.string.magic_8_ball_3
            4 -> R.string.magic_8_ball_4
            5 -> R.string.magic_8_ball_5
            6 -> R.string.magic_8_ball_6
            7 -> R.string.magic_8_ball_7
            8 -> R.string.magic_8_ball_8
            9 -> R.string.magic_8_ball_9
            10 -> R.string.magic_8_ball_10
            11 -> R.string.magic_8_ball_11
            12 -> R.string.magic_8_ball_12
            13 -> R.string.magic_8_ball_13
            14 -> R.string.magic_8_ball_14
            15 -> R.string.magic_8_ball_15
            16 -> R.string.magic_8_ball_16
            17 -> R.string.magic_8_ball_17
            18 -> R.string.magic_8_ball_18
            19 -> R.string.magic_8_ball_19
            20 -> R.string.magic_8_ball_20
            else -> R.string.app_name
        }

        ivMagicBall.setImageResource(imageResource)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

    private fun getRandomChoise(i: Int): Any {
        return Random().nextInt(i)+1
    }
}