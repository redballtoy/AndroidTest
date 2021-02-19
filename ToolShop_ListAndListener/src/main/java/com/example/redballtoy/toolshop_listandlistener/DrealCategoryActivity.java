package com.example.redballtoy.toolshop_listandlistener;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DrealCategoryActivity extends AppCompatActivity {

    private ListView listDrills;
    private List<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreal_category);

        listDrills = findViewById(R.id.lv_dreals);
        drills = new ArrayList<>();
        drills.add(new Drill("Дрил1", "Info о Дрил1", R.string.dreal_activity_label));

        //для связи нужен адаптер
        ArrayAdapter<Drill> drillArrayAdapter = new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1,
                drills);
        listDrills.setAdapter(drillArrayAdapter);





    }
}