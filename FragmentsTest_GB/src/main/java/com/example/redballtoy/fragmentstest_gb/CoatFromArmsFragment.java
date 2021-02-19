package com.example.redballtoy.fragmentstest_gb;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;


public class CoatFromArmsFragment extends Fragment {

    //getted attributes key of city elements
    private int index;
    private static final String KEY_INDEX = "index";


    public CoatFromArmsFragment() {
        // Required empty public constructor
    }

    //setting parameters of list cities item index
    public static CoatFromArmsFragment newInstance(int index) {
        CoatFromArmsFragment fragment = new CoatFromArmsFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_INDEX, index);
        fragment.setArguments(args);
        Log.d("myLog", "CoatFromArmsFragment: newInstance:" + index);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get arguments if they are not null
        Log.d("myLog", "CoatFromArmsFragment: onCreate" );
        if (getArguments() != null) {
            //save to a index what was passed
            index = getArguments().getInt(KEY_INDEX);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("myLog", "CoatFromArmsFragment: onCreateView" );
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coat_from_arms, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("myLog", "CoatFromArmsFragment: onViewCreated" );
        AppCompatImageView imageCoatOfArms = new AppCompatImageView(view.getContext());
        //AppCompatImageView imageCoatOfArms = view.findViewById(R.id.iv_iv_coat_of_arms);
        //get  an array of pointers to images coats of arm
        TypedArray imagePointers = getResources().obtainTypedArray(R.array.coat_of_arms_of_the_city);
        //select a suitable link by index and set to ImageView
        imageCoatOfArms.setImageResource(imagePointers.getResourceId(index, -1));
        LinearLayoutCompat llCoatFromArmsImage = view.findViewById(R.id.ll_coat_from_arms_image);
        LinearLayoutCompat.LayoutParams llCoatFromArmsImageParams = new LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT);
        llCoatFromArmsImage.setOrientation(LinearLayoutCompat.VERTICAL);
        llCoatFromArmsImage.addView(imageCoatOfArms,llCoatFromArmsImageParams);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("myLog", "CoatFromArmsFragment: onAttach(@NonNull Context context)" );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("myLog", "CoatFromArmsFragment: onStart()" );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myLog", "CoatFromArmsFragment: onResume()" );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("myLog", "CoatFromArmsFragment: onPause()" );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("myLog", "CoatFromArmsFragment: onStop()" );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLog", "CoatFromArmsFragment: onDestroyView()" );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myLog", "CoatFromArmsFragment: onDestroy()" );
    }
    
}