package com.example.redballtoy.z_braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTimer;
    private TextView tvScore;
    private TextView tvQuestion;
    private TextView tvOpinion_00;
    private TextView tvOpinion_01;
    private TextView tvOpinion_02;
    private TextView tvOpinion_03;
    private Button btStart;
    private Button btExit;
    private Snackbar mySnackbar;


    private final ArrayList<TextView> tv = new ArrayList<>();


    private String question;
    private int rightAnswer;
    private int positionRightAnswer;
    private boolean isPositive; //знак

    //границы генерирования числа
    private final int minSource = 5;
    private final int maxSource = 30;

    //результаты ответов
    //количество заданных вопросов
    private int countQuestion = 0;
    //количество правильных ответов
    private int countRightAnswer = 0;

    //таймер
    private CountDownTimer countDownTimer;
    private final long totalSec = 20;
    private final long intervalSec = 1;
    private boolean gameOver = false;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimer = findViewById(R.id.tv_timer);
        tvScore = findViewById(R.id.tv_score);
        tvQuestion = findViewById(R.id.tv_question);
        tvOpinion_00 = findViewById(R.id.tv_opinion_00);
        tvOpinion_01 = findViewById(R.id.tv_opinion_01);
        tvOpinion_02 = findViewById(R.id.tv_opinion_02);
        tvOpinion_03 = findViewById(R.id.tv_opinion_03);
        btStart = findViewById(R.id.bt_start);
        btExit = findViewById(R.id.bt_exit);

        tvOpinion_00.setOnClickListener(this);
        tvOpinion_01.setOnClickListener(this);
        tvOpinion_02.setOnClickListener(this);
        tvOpinion_03.setOnClickListener(this);
        btStart.setOnClickListener(this);
        btExit.setOnClickListener(this);


        //заносим в массив все TextView
        tv.add(tvOpinion_00);
        tv.add(tvOpinion_01);
        tv.add(tvOpinion_02);
        tv.add(tvOpinion_03);

    }

    private void countDownTimer() {
        //создание тайммера
        countDownTimer = new CountDownTimer(totalSec * 1000, intervalSec * 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(getTime(millisUntilFinished));
                if (millisUntilFinished < 10000) {
                    tvTimer.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }else{
                    tvTimer.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                }


            }

            @Override
            public void onFinish() {
                gameOver=true;
                btStart.setText(getString(R.string.restart));
                btStart.setVisibility(Button.VISIBLE);
                btExit.setVisibility(Button.VISIBLE);
                tvQuestion.setText("");

            }
        };
        countDownTimer.start();

    }

    //  метод генерирования вопроса и правильного ответа
    private void generateQuestion() {
        //получить два случайных числа
        //int a = new Random().nextInt(maxSource - minSource) + minSource;
        //int b = new Random().nextInt(maxSource - minSource) + minSource;
        //Другой вариант для получения случайного числа от 5 до 30
        int a = (int) (Math.random() * (maxSource - minSource + 1) + maxSource);
        int b = (int) (Math.random() * (maxSource - minSource + 1) + maxSource);
        //получение случайного знака + или - (посучим либо 0 либо 1)
        int mark = (int) (Math.random() * 2);
        isPositive = mark == 1;
        //формирование вопроса
        if (isPositive) {
            rightAnswer = a + b;
            question = String.format("%s + %s", a, b);
        } else {
            rightAnswer = a - b;
            question = String.format("%s - %s", a, b);
        }

        //генерирование индекса правильного ответа
        //необхочимо число 0 - 3 включительно
        positionRightAnswer = (int) (Math.random() * 4);
        //Генерируем вопрос и устанавливаем его
        tvQuestion.setText(question);
    }

    //метод генерирования неверных ответов
    private int generaWrongAnswer() {
        //Полученное число должно отличаться от правильного ответа
        int result;
        do {
            //границы ответа могут быть от min 5-30 = -25 max 5+30 = 35
            //всего возможных значений 2 * 30 = 60, что бы получить их
            result = (int) (Math.random() * maxSource * 2 + 1);
            //что бы получить от -25 до +35 = (0..60) - 25
            result -= (maxSource - minSource);
        } while (rightAnswer == result);

        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                //Обнуление счетчиков
                countRightAnswer = 0;
                countQuestion = 0;
                //создание вопроса при запуске игры
                playNext();
                //создание тайммера
                countDownTimer();
                btStart.setVisibility(View.GONE);
                btExit.setVisibility(View.GONE);
                gameOver=false;
                break;
            case R.id.bt_exit:
                mySnackbar= Snackbar.make(findViewById(R.id.cl_root), R.string.exit_message,
                        Snackbar.LENGTH_LONG);
                mySnackbar.setAction(R.string.exit_undo, new MyUndoListener());
                mySnackbar.show();

                //System.exit(1);
                break;
            default:
                if (gameOver!=true) {
                    //получаем результат указанный на выбранном варианте
                    TextView tv = (TextView) v;
                    String res = tv.getText().toString();
                    if (res.equals(String.valueOf(rightAnswer))) {
                        //Toast.makeText(this, "Правильный ответ! :)", Toast.LENGTH_SHORT).show();
                        countRightAnswer++;
                    } else {
                        //Toast.makeText(this, "Ответ не верный :(", Toast.LENGTH_SHORT).show();
                    }
                    countQuestion++;
                    playNext();
                }
        }
    }

    private void setQuestionResult() {
        String outRes = String.format("%s/%s", countQuestion, countRightAnswer);
        tvScore.setText(outRes);
    }

    //создание нового вопроса при нажатии на клавишу
    private void playNext() {
        //генерируем вопрос
        generateQuestion();
        //устанавливаем значения вариантам
        for (int i = 0; i < tv.size(); i++) {
            if (i == positionRightAnswer) {
                //устанавливаем правильный ответ
                tv.get(i).setText((Integer.toString(rightAnswer)));
            } else {
                //устанавливаем текст со сгенерированным неправильным ответом
                tv.get(i).setText(Integer.toString(generaWrongAnswer()));
            }
        }
        setQuestionResult();
    }

    //метод для форматирования времени в читаемую строку
    private String getTime(long milliseconds) {
        //получить количетво секунд
        int seconds = (int) milliseconds / 1000;
        //количество минут и секунд
        int minutes = seconds / 60;
        seconds = seconds % 60;
        //формат даты включает значения минут и секунд имеющих минимуи два знака
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

}