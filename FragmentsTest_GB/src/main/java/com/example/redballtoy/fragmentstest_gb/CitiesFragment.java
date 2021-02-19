package com.example.redballtoy.fragmentstest_gb;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textview.MaterialTextView;


//В этом фрагменте создаем список городов
public class CitiesFragment extends Fragment {

    private static final String TAG = "myLog" ;
    private static final String KEY_INDEX = "index";

    public CitiesFragment() {
        // Required empty public constructor
    }

    public static CitiesFragment newInstance() {
        CitiesFragment fragment = new CitiesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("myLog", "CitiesFragment: onCreate" );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("myLog", "CitiesFragment: onCreateView" );
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("myLog", "CitiesFragment: onViewCreated" );
        initList(view);
    }

    private void initList(View view) {
        LinearLayoutCompat layout = (LinearLayoutCompat) view;
        //получаем список городов
        String[] cities = getResources().getStringArray(R.array.citizens);
        Log.d("myLog", "CitiesFragment: initList" );

        //создание элемента списка TextView, добавление его на экран
        //и заполняем значениями списка
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            //Проверять что контекст не null,
            Context context = getContext();
            if (context == null) {
                Log.e(TAG, "initList: Context is null");
                return;
            }
            MaterialTextView tvItemCities = new MaterialTextView(context);
            tvItemCities.setText(city);
            tvItemCities.setTextSize(30);
            layout.addView(tvItemCities);
            int finalI = i;
            tvItemCities.setOnClickListener(new View.OnClickListener() {
                final int fi = finalI;
                @Override
                public void onClick(View v) {
                    CoatFromArmsFragment details = new CoatFromArmsFragment();
                    CoatFromArmsFragment.newInstance(fi);
                    Log.d("myLog", "CitiesFragment: "+fi );
                    FragmentManager fragmentManager = requireFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();







                    
                }


            });
        }

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("myLog", "CitiesFragment: onAttach(@NonNull Context context)" );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("myLog", "CitiesFragment: onStart()" );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myLog", "CitiesFragment: onResume()" );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("myLog", "CitiesFragment: onPause()" );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("myLog", "CitiesFragment: onStop()" );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLog", "CitiesFragment: onDestroyView()" );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myLog", "CitiesFragment: onDestroy()" );
    }
}