package com.example.redballtoy.recyclerviewtestklimov_01

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class BigFotoCote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_foto_cote)

        val ivShowBigFoto: ImageView = findViewById(R.id.iv_big_cote_foto)
        val intent = intent
        val imageId = intent.getIntExtra("imageId", 1)
        ivShowBigFoto.setImageResource(imageId)

    }
}