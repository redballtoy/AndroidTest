package com.example.redballtoy.fragmentstest_gb;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("myLog", "MainActivity: onCreate()" );



        if (savedInstanceState == null) {
            CoatFromArmsFragment details = new CoatFromArmsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_INDEX, 4);

            details.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_fragment_coat_from_arms,details).commit();

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myLog", "MainActivity: onStart()" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myLog", "MainActivity: onRestart()" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myLog", "MainActivity: onResume()" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myLog", "MainActivity: onResume()" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myLog", "MainActivity: onStop()" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myLog", "MainActivity: onDestroy()" );
    }
}