package com.angoma.arianpc.laboratoriocalificado.repositories;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angoma.arianpc.laboratoriocalificado.R;
import com.angoma.arianpc.laboratoriocalificado.adapters.NoteAdapter;
import com.angoma.arianpc.laboratoriocalificado.models.Note;

import java.util.List;

public class FragmentQuiz extends Fragment {

    private RecyclerView notesList;

    View view;

    public FragmentQuiz() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.store_fragment, container, false);

        notesList = (RecyclerView)view.findViewById(R.id.listView);
        notesList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));

//        FloatingActionButton fab = view.findViewById(R.id.btn_float);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return view;
    }

    public void refreshList(){
        NoteAdapter adapter = (NoteAdapter) notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }

}
