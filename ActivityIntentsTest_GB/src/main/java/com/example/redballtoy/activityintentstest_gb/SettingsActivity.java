package com.example.redballtoy.activityintentstest_gb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class SettingsActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editSurname;
    private EditText editAge;
    private EditText editEmail;
    private final Account account = new Account();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();

        //get data from intent
        Account account = getIntent().getExtras().getParcelable(MainActivity.YOUR_ACCOUNT);

        if(account!=null) {
            populateViewAccount(account);
        }


        Button btReturn = findViewById(R.id.bt_return);
        btReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.setName(editName.getText().toString());
                account.setSurName(editSurname.getText().toString());
                account.setAge(Integer.parseInt(editAge.getText().toString()));
                account.setEmail(editEmail.getText().toString());

                //при возврате не нужно указывать направление передачи, в данном случае
                //интент используется просто как посылка
                Intent intentResult = new Intent();
                intentResult.putExtra(MainActivity.YOUR_ACCOUNT, account);
                //если пользователь что то делал надо вернуть результат
                setResult(RESULT_OK, intentResult);
                finish();

            }
        });
    }

    private void initViews() {
        editName = findViewById(R.id.et_name);
        editSurname = findViewById(R.id.et_surname_name);
        editAge = findViewById(R.id.et_your_age);
        editEmail = findViewById(R.id.et_your_mail);
    }

    //нужно проверять на NULL или ставить аннотацию @NonNull
    private void populateViewAccount(@NonNull Account account) {
        editName.setText(account.getName());
        editSurname.setText(account.getSurName());
        editAge.setText(String.format(Locale.getDefault(), "%d", account.getAge()));
        editEmail.setText(account.getEmail());
    }
}