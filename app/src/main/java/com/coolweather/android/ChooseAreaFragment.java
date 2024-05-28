package com.coolweather.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.coolweather.android.databinding.ChooseAreaBinding;

public class ChooseAreaFragment extends Fragment {
    ChooseAreaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       binding=ChooseAreaBinding.inflate(inflater,container,false);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
