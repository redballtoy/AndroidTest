package com.example.redballtoy.layoutscafeorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etInputLogin, etInputPassword, etInputEmail;
    Button btCreateOrder;
    private final String PASS_RIGHT = "1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etInputLogin = findViewById(R.id.et_input_name);
        etInputPassword = findViewById(R.id.et_input_password);
        etInputEmail = findViewById(R.id.et_input_email);
        btCreateOrder = findViewById(R.id.bt_login);
        btCreateOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String login = etInputLogin.getText().toString().trim();
        String pass = etInputPassword.getText().toString().trim();
        String email = etInputEmail.getText().toString().trim();

        if (!pass.equals(PASS_RIGHT) || login.equals("") || email.equals("")) {
            Toast.makeText(this, getString(R.string.toast_login_correct)
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, CreatedOrderActivity.class);
        intent.putExtra("name", login);
        intent.putExtra("pass", pass);
        intent.putExtra("email", email);

        startActivity(intent);
    }
}