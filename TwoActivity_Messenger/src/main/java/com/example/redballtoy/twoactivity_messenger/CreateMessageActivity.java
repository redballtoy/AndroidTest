package com.example.redballtoy.twoactivity_messenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMessageActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etInputMessageBody, etInputSubject;
    Button btSendMessage ,btSendMessageByOtherApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        etInputMessageBody = findViewById(R.id.et_enter_message_text);
        etInputSubject=findViewById(R.id.et_subject);

        btSendMessage = findViewById(R.id.bt_send);
        btSendMessage.setOnClickListener(this);

        btSendMessageByOtherApp = findViewById(R.id.bt_send_by_other_app);
        btSendMessageByOtherApp.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_send:
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ReceivedMessageActivity.class);
                intent.putExtra("message", etInputMessageBody.getText().toString());
                startActivity(intent);
                break;
            case R.id.bt_send_by_other_app:
                Toast.makeText(this, "Find app to send", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, etInputSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etInputMessageBody.getText().toString());
                //Создание обязательного окна выбора
                Intent intentChooser = Intent.createChooser(intent, getString(R.string.chooser_header));
                //startActivity(intent);
                startActivity(intentChooser);
                break;
        }


    }
}