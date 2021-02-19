package com.example.redballtoy.recyclerviewsumin_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redballtoy.recyclerviewsumin_notes.adapter.NotesAdapter;
import com.example.redballtoy.recyclerviewsumin_notes.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvNotes;
    public final static ArrayList<Note> notes = new ArrayList<>();

    private final NotesAdapter notesAdapter = new NotesAdapter(notes);

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (notes.isEmpty()) {
            //Add notes for Testing
            notes.add(new Note("Первая заметка", "О первом событии", "Суббота", 1));
            notes.add(new Note("Парикмахер", "Сходить подстричься", "Вторник", 2));
            notes.add(new Note("Магазин", "Купить новые джинсы", "Вторник", 1));
            notes.add(new Note("Прогулка", "Погулять вечером", "Вторник", 3));
            notes.add(new Note("Магазин", "Купить макарошки", "Среда", 2));
        }


        rvNotes = findViewById(R.id.rv_notes);


        //set recycler view orientation
        //rvNotes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        //for grid, attribute context and row count
        rvNotes.setLayoutManager(new GridLayoutManager(this, 3));
        //set adapter for recycler view
        rvNotes.setAdapter(notesAdapter);

        fab = findViewById(R.id.fb_add_notes);
        fab.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb_add_notes:
                Intent intent = new Intent(this,AddNoteActivity.class);
                startActivity(intent);
                break;
            default:
        }


    }
}