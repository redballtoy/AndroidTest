package com.example.redballtoy.fragmenttofragmentcommunication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    IMainActivity mainActivity;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (IMainActivity) getActivity();
    }
}
