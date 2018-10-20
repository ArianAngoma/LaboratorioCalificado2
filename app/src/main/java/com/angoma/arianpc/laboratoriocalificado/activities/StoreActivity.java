package com.angoma.arianpc.laboratoriocalificado.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.angoma.arianpc.laboratoriocalificado.R;
import com.angoma.arianpc.laboratoriocalificado.adapters.NoteAdapter;
import com.angoma.arianpc.laboratoriocalificado.models.Note;
import com.angoma.arianpc.laboratoriocalificado.repositories.NoteRepository;

import java.util.List;

public class StoreActivity extends AppCompatActivity {

    private static final String TAG = StoreActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_fragment);

        notesList = (RecyclerView)findViewById(R.id.listView);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));
    }

    public void callRegisterForm(View view) {
        startActivityForResult(new Intent(this, AddActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NoteAdapter adapter = (NoteAdapter) notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }
}
