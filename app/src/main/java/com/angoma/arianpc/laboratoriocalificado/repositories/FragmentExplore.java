package com.angoma.arianpc.laboratoriocalificado.repositories;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angoma.arianpc.laboratoriocalificado.R;

public class FragmentExplore extends Fragment {

    View view;

    public FragmentExplore() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.explore_fragment, container, false);

        return view;
    }
}
