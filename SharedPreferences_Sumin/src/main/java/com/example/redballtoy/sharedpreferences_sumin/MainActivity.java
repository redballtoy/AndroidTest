package com.example.redballtoy.sharedpreferences_sumin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//Первый из типов хранения данных, в SharedPreferences можно хранить значение
//любого примитивного типа

public class MainActivity extends AppCompatActivity {

    private final String FIRST_VAL = "firstVal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Получить SharedPreferences самым простым способом
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //занесение данных которые хотим сохранить
        //закомментить для перезапуска
        //sharedPreferences.edit().putInt(FIRST_VAL, 5).apply();
        //поллучение сохраненного значения
        int test = sharedPreferences.getInt(FIRST_VAL, 0);
        Toast.makeText(this, "firstVal= " + test, Toast.LENGTH_LONG).show();

    }

}