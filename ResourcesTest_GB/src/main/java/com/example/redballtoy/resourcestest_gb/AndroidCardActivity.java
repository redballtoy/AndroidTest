package com.example.redballtoy.resourcestest_gb;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class AndroidCardActivity extends AppCompatActivity {


    SwitchCompat scEnRu;
    private boolean swCheck = false;
    private boolean swCheckSaved = false;
    final String SWITCH_POSITION_KEY = "switch_position";
    private boolean changeOrient = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_versions_cart);
        if (savedInstanceState != null) {
            swCheckSaved = savedInstanceState.getBoolean(SWITCH_POSITION_KEY);
            changeOrient = true;
        }

        getSupportActionBar().hide();

        int position = getIntent().getIntExtra("position", -1);
        TextView tvCardHeader = findViewById(R.id.tv_card_header);
        ImageView ivCard = findViewById(R.id.iv_card_logo);
        TextView tvDescription = findViewById(R.id.tv_card_description);
        scEnRu = findViewById(R.id.swc_en_ru);

        String[] heads = getResources().getStringArray(R.array.version_name);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.version_log);
        String[] descriotionEn = getResources().getStringArray(R.array.version_description_en);
        String[] descriotionRu = getResources().getStringArray(R.array.version_description_ru);

        tvCardHeader.setText(heads[position]);
        ivCard.setImageResource(typedArray.getResourceId(position, -1));

        if (changeOrient) {
            swCheck = swCheckSaved;
        } else {
            swCheck = scEnRu.isChecked();
        }

        if (!swCheck) {
            tvDescription.setText(descriotionEn[position]);
        } else {
            tvDescription.setText(descriotionRu[position]);
        }

        scEnRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swCheck = scEnRu.isChecked();
                if (!swCheck) {
                    tvDescription.setText(descriotionEn[position]);
                } else {
                    tvDescription.setText(descriotionRu[position]);
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SWITCH_POSITION_KEY, scEnRu.isChecked());
    }


}