package com.example.redballtoy.fragmentyandextest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;


public class FirstFragment extends Fragment {

    public static final String ARG_KEY = "index";

    public FirstFragment() {
    }

    //pass the received parameters to the fragment
    public static FirstFragment newInstance(String index) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_KEY, 2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initList() {
        LinearLayoutCompat llContainer = new LinearLayoutCompat(getContext());
        String[] cities = getResources().getStringArray(R.array.citizens);
        for (int i = 0; i <cities.length ; i++) {
            String city = cities[i];
            AppCompatTextView tv = new AppCompatTextView(getContext());
            tv.setText(city);
            llContainer.addView(tv);

        }


    }

}