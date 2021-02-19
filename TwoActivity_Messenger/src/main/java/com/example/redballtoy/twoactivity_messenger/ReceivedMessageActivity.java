package com.example.redballtoy.twoactivity_messenger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceivedMessageActivity extends AppCompatActivity {

    TextView tvShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);

        tvShowMessage = findViewById(R.id.tv_show_messages);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        tvShowMessage.setText(message);


    }
}