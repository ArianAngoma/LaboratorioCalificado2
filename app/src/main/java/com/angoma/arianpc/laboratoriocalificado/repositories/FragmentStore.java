package com.angoma.arianpc.laboratoriocalificado.repositories;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angoma.arianpc.laboratoriocalificado.R;

public class FragmentStore extends Fragment {

    View view;

    public FragmentStore() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.quiz_fragment, container, false);

        return view;
    }
}
