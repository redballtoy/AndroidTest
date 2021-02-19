package com.example.redballtoy.recyclerviewsumin_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redballtoy.recyclerviewsumin_notes.model.Note;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etInputTitle;
    EditText etInputDescription;
    RadioGroup rgSetPriority;
    Spinner spSetDayOfWeek;
    Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        btSave = findViewById(R.id.bt_save);
        etInputTitle = findViewById(R.id.et_edit_title);
        spSetDayOfWeek = findViewById(R.id.sp_choose_day_of_week);
        rgSetPriority = findViewById(R.id.rg_priority);
        etInputDescription = findViewById(R.id.et_edit_description);

        btSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title = etInputTitle.getText().toString().trim();
        String description = etInputDescription.getText().toString().trim();
        String dayWeekly = spSetDayOfWeek.getSelectedItem().toString();
        int RadioButtonId = rgSetPriority.getCheckedRadioButtonId();
        RadioButton rbPriority = findViewById(RadioButtonId);
        int priority = 0;
        String priorityKey = rbPriority.getText().toString();
        if (priorityKey.equals(getString(R.string.low))) {
            priority = 1;
        } else if (priorityKey.equals(getString(R.string.middle))) {
            priority = 2;
        } else if (priorityKey.equals(getString(R.string.high))) {
            priority = 3;
        }
        //Создаем новую заметку
        Note note = new Note(title, description, dayWeekly, priority);
        MainActivity.notes.add(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
