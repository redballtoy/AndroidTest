package com.example.redballtoy.cycleactivitystopwatch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView showTime;
    Button startButton, pauseButton, clearButton;
    int secondsPast = 0; //количество прошедших секунд
    boolean isWatchRunning = false; //признак того работает ли секундомер сейчас
    boolean wasRunning = false;//состояние таймера до вызова onStop


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            secondsPast = savedInstanceState.getInt("secondsPast");
            isWatchRunning = savedInstanceState.getBoolean("isWatchRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        setContentView(R.layout.activity_main);

        showTime = findViewById(R.id.tv_show_digit);
        startButton = findViewById(R.id.bt_start);
        pauseButton = findViewById(R.id.bt_pause);
        clearButton = findViewById(R.id.bt_clear);

        startButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        runTimer();
        Toast.makeText(this,"onCreate()",Toast.LENGTH_SHORT).show();
    }

    /* Не используем потому что аналогичный функционал реадизовали onPause() и onResume()
    //Используем что бы останавливать таймер когда активность теряет видимость
    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = isWatchRunning;
        isWatchRunning = false;
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();

    }


    //Возобновляем работу таймера когда активность становится снова видимой
    //восстанавливаем состояние переменной isRunning в состояние до onStop
    @Override
    protected void onStart() {
        super.onStart();
        isWatchRunning = wasRunning;
        Toast.makeText(this,"onStart()",Toast.LENGTH_SHORT).show();
    }
    */


    @Override
    protected void onPause() {
        super.onPause();
        //Сохрание состояния таймера а после его остановку
        wasRunning = isWatchRunning;
        isWatchRunning = false;

        Toast.makeText(this,"onPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isWatchRunning = wasRunning;
        Toast.makeText(this,"onResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("secondsPast", secondsPast);
        //outState.putInt("isWatchRunning",Integer.parseInt(String.valueOf(isWatchRunning)));
        outState.putBoolean("isWatchRunning", isWatchRunning);
        outState.putBoolean("wasRunning", wasRunning);
        Toast.makeText(this,"onSaveInstance",Toast.LENGTH_SHORT).show();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                onClickStartTimer();
                break;
            case R.id.bt_pause:
                onClickPauseTimer();
                break;
            case R.id.bt_clear:
                onClickClearTimer();
                break;
        }

    }

    private void onClickStartTimer() {
        isWatchRunning = true;

    }

    private void onClickPauseTimer() {
        isWatchRunning = false;
    }

    private void onClickClearTimer() {
        isWatchRunning = false;
        secondsPast = 0;

    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = secondsPast / 3600;
                int minutes = (secondsPast % 3600) / 60;
                int seconds = secondsPast % 60;

                String time = String.format(Locale.getDefault()
                        , "%d:%02d:%02d",
                        hours, minutes, seconds);
                showTime.setText(time);
                if (isWatchRunning) {
                    secondsPast++;
                }
                handler.postDelayed(this, 1000);
            }
        });


    }
}