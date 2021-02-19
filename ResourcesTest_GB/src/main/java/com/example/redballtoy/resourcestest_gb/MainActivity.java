package com.example.redballtoy.resourcestest_gb;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ArrayList<AndroidVersionModelData> androidVersionList = new ArrayList<>();
    ListView listView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tfBoycott = Typeface.createFromAsset(getAssets(), "fonts/BOYCOTT_.ttf");
        TextView tvLanguage = findViewById(R.id.tv_language);
        tvLanguage.setTypeface(tfBoycott);

        populateArrayList();
        initList();


    }

    //Динамическое создание макетов и их наполнение из массивов
    private void initList() {
        //Создание адаптера для конвертации данных во вью
        MyAdapter myAdapter = new MyAdapter(this, androidVersionList);
        //Присоединяем адаптер к ListView
        listView = findViewById(R.id.lv_android_version);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);

    }

    //Заполняем массив данными
    private void populateArrayList() {
        String[] androidName = getResources().getStringArray(R.array.version_name);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.version_log);
        for (int i = 0; i < androidName.length; i++) {
            androidVersionList.add(new AndroidVersionModelData(
                    androidName[i], typedArray.getResourceId(i, -1)));
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, AndroidCardActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}