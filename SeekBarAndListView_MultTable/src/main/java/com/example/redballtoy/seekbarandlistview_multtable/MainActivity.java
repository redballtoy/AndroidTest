package com.example.redballtoy.seekbarandlistview_multtable;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbMultBar;
    private final int SEEKBAR_PROGRESS_MAX = 10;
    private final int SEEKBAR_PROGRESS_MIN = 1;
    private final int COUNT_ITEMS_SHOW_AT_TABLE = 10;

    private ListView lvMultTable;

    //ListView будет содержать массив чисел
    private ArrayList<MultItem> numbers;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMultTable = findViewById(R.id.lv_mult_tables);
        sbMultBar = findViewById(R.id.sb_mult);
        sbMultBar.setMax(SEEKBAR_PROGRESS_MAX);
        numbers = new ArrayList<>();


        sbMultBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //когда меняется прогресс
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (int i = SEEKBAR_PROGRESS_MIN; i <= COUNT_ITEMS_SHOW_AT_TABLE ; i++) {
                    numbers.add(new MultItem(i, i * progress));
                }


            }

            //пользователь только начинает двигать кружок
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }


            //когда отпускает кружок
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}