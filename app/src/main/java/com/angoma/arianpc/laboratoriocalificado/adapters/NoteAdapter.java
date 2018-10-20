package com.angoma.arianpc.laboratoriocalificado.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.angoma.arianpc.laboratoriocalificado.R;
import com.angoma.arianpc.laboratoriocalificado.models.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.mainTitle);
            desc = (TextView) itemView.findViewById(R.id.mainDesc);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_notes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note note = this.notes.get(position);
        viewHolder.title.setText(note.getTitulo());
        viewHolder.desc.setText(note.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}


