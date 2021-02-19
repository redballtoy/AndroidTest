package com.example.redballtoy.colortestsumin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spSelectColor;
    private TextView showDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSelectColor = findViewById(R.id.sp_select_color);
        showDescription = findViewById(R.id.tw_show_description);

        spSelectColor.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        showDescription.setText(getDescriptions(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String getDescriptions(int position) {
        String[] descriptions = getResources().getStringArray(R.array.color_descriptions);
        return descriptions[position];
    }

}