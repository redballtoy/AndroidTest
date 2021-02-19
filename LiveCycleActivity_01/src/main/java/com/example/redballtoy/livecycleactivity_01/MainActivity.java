package com.example.redballtoy.livecycleactivity_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String keyCounters = "Counters";

    Button btCount;
    TextView tvCount;
    Counters counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("myLog", "onCreate()");
        if (savedInstanceState == null) {
            Log.i("myLog", "onCreate():savedInstanceState == null - Первый запуск");
        } else {
            Log.i("myLog", "onCreate(): savedInstanceState != null - Повторный запуск");
         }

        btCount = findViewById(R.id.bt_count);
        tvCount = findViewById(R.id.tv_count_view);
        btCount.setOnClickListener(this);

        counter = new Counters();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("myLog", "onStart()");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("myLog", "onRestoreInstanceState() - Повторный запуск");
        counter = (Counters) savedInstanceState.getSerializable(keyCounters);
        //перезаполнить поля
        setTextCounter();
    }

    private void setTextCounter() {
        tvCount.setText(String.valueOf(counter.getCounter()));
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("myLog", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("myLog", "onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("myLog", "onSaveInstanceState()");
        outState.putSerializable(keyCounters,counter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("myLog", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("myLog", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("myLog", "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        Log.i("myLog", "onClick() - Клик!");
        tvCount.setText(counter.increaseCuunter());
    }
}