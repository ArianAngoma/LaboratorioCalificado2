package com.angoma.arianpc.laboratoriocalificado.repositories;

import com.angoma.arianpc.laboratoriocalificado.models.Note;
import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static Note read(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(String title, String desc){
        Note note = new Note(title, desc);
        SugarRecord.save(note);
    }

    public static void update(String title, String desc, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setTitulo(title);
        note.setDescripcion(desc);
        SugarRecord.save(note);
    }

    public static void delete(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        SugarRecord.delete(note);
    }
}
