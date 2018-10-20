package com.angoma.arianpc.laboratoriocalificado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.angoma.arianpc.laboratoriocalificado.R;
import com.angoma.arianpc.laboratoriocalificado.repositories.NoteRepository;

public class AddActivity extends AppCompatActivity {

    private EditText tituloInput;
    private EditText descInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tituloInput = (EditText)findViewById(R.id.input_titulo);
        descInput = (EditText)findViewById(R.id.input_desc);
    }

    public void callRegister(View view){
        String titulo = tituloInput.getText().toString();
        String desc = descInput.getText().toString();

        if(titulo.isEmpty() || desc.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        NoteRepository.create(titulo, desc);

        finish();
    }
}
