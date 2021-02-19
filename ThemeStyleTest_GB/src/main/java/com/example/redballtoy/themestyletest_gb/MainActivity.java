package com.example.redballtoy.themestyletest_gb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Spinner spinner;
    private static final String TAG = "myLog";
    private static final String THEME_NAME_ID = "ThemeNameId";
    private int myThemeId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set theme
        sharedPreferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
        myThemeId = sharedPreferences.getInt(THEME_NAME_ID, 0);
        setTheme(getResourceFromPosition(myThemeId));
        Log.d(TAG, "onCreate: pozition restored= " + myThemeId);


        //set layout file
        setContentView(R.layout.activity_main);

        //init
        spinner = (Spinner) findViewById(R.id.sp_changeTheme);
        //TODO - по имени темы устанвить выбранный элемент

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //если сохранненое значение и значение выбранное совпадают ничего не делаем
                int getPositionId = getPosition();
                Log.d(TAG, "onItemSelected: getPositionId= " + getPositionId);
                Log.d(TAG, "onItemSelected: position= " + position);
                if (getPositionId != position) {
                    savePosition(position);
                    Log.d(TAG, "onItemSelected: recreate= " + position);
                    recreate();
                }

            }

            private int getPosition() {
                sharedPreferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
                return sharedPreferences.getInt(THEME_NAME_ID, 0);
            }

            private void savePosition(int position) {
                sharedPreferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(THEME_NAME_ID, position);
                editor.apply();
                Log.d(TAG, "savePosition: save position = " + sharedPreferences.getInt(THEME_NAME_ID, 0));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private int getResourceFromPosition(int myThemeId) {
        switch (myThemeId) {
            case 0:
                return R.style.ThemeStyleTest;
            case 1:
                return R.style.myStyleNoAcionBar;
            case 2:
                return R.style.myStyleLight;
            case 3:
                return R.style.myStyleNight;

        }
        return -1;
    }
}