package com.example.redballtoy.activityintentstest_gb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //не должна private что бы была доступна в другой активити
    final static String YOUR_ACCOUNT = "YOUR_ACCOUNT";
    private EditText etInputName;
    private Account account = new Account();
    //уникальный код что бы отличать результат полученный от SettingActivity от другой
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private static final String SEARCH_URL = "https://www.google.com/search?client=firefox-b-d&q=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Button btGreeting = findViewById(R.id.bt_greetings);
        etInputName = findViewById(R.id.et_edit_text);
        final TextView tvGreeting = findViewById(R.id.tv_title);
        btGreeting.setOnClickListener(v -> {
            String name = etInputName.getText().toString();
            String sayHello = String.format("%s: %s", getString(R.string.privet), name);
            tvGreeting.setText(sayHello);
        });

        Button btSettings = findViewById(R.id.bt_settings);
        btSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            populateAccount();
            intent.putExtra(YOUR_ACCOUNT, account);
            startActivityForResult(intent, REQUEST_CODE_SETTING_ACTIVITY);

        });

        Button btFindName = findViewById(R.id.bt_find);
        btFindName.setOnClickListener(v -> {
            String url = SEARCH_URL + etInputName.getText().toString();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }

    private void populateAccount() {
        account.setName(etInputName.getText().toString());
    }

    //Коллбек вызываемый при получении результата
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            account = data.getParcelableExtra(YOUR_ACCOUNT);
            showResult();
        }
    }

    private void showResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(Locale.getDefault(), "Name: %s\n", account.getName()));
        stringBuilder.append(String.format(Locale.getDefault(), "SurName: %s\n", account.getSurName()));
        stringBuilder.append(String.format(Locale.getDefault(), "Age: %d\n", account.getAge()));
        stringBuilder.append(String.format(Locale.getDefault(), "Email: %s\n", account.getEmail()));
        TextView tvResult = findViewById(R.id.tv_result);
        tvResult.setText(stringBuilder.toString());
    }
}