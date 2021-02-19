package com.example.redballtoy.layoutscafeorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderInfo extends AppCompatActivity implements View.OnClickListener {

    private String name;
    private String pass;
    private String email;
    private boolean isTea;
    private boolean isMilk;
    private boolean isSugar;
    private boolean isLemon;
    private int drinkItem;
    private Button sendEmail;
    private int orderNumber;
    private String todayDate;
    private String stringHeader;
    private String detailOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        sendEmail = findViewById(R.id.bt_send_to_email);
        sendEmail.setOnClickListener(this);

        getIntentFromSecondActivity();
        showOrderDetail();


    }

    private void showOrderDetail() {
        TextView tvTitleOrder = findViewById(R.id.tv_order_info_title);
        TextView tvOrderDetail = findViewById(R.id.tv_order_details);

        orderNumber = (int) (Math.random() * 1000);
        todayDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        stringHeader = "Заказ №: " + orderNumber
                + "\n от " + todayDate
                +"\n Имя клиента: "+name
                +"\n Email клиента: "+email
                +"\n Пароль клиента: "+pass
                +"\n\n Состав заказа:";
        tvTitleOrder.setText(stringHeader);

        //Drink
        String drink;
        if (isTea) {
            drink = getString(R.string.tea);
        }else {
            drink = getString(R.string.cofe);
        }

        //Add
        String milkAdd = getTextAdd(isMilk, R.string.milk);
        String sugarAdd = getTextAdd(isSugar, R.string.sugar);
        String lemonAdd = getTextAdd(isLemon, R.string.lemon);

        //Drink Item
        String getDrink = getDrink(isTea, drinkItem);
        detailOrder = "Напиток: " + drink + " " + getDrink
                +"\n Добавки в "+drink.toLowerCase()+": "+
                milkAdd+" "+sugarAdd+" "+lemonAdd;

        tvOrderDetail.setText(detailOrder);

    }

    private String getDrink(boolean isDrink, int drinkItem) {
        if (isDrink) {
            return (getResources().getStringArray(R.array.tea_array)[drinkItem]).toLowerCase();
        } else {
            return (getResources().getStringArray(R.array.kofe_array)[drinkItem]).toLowerCase();
        }
    }

    private String getTextAdd(boolean isAdd, int strRef) {
        if (isAdd) {
            return getString(strRef).toLowerCase();
        } else {
            return "";
        }
    }

    private void getIntentFromSecondActivity() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pass = intent.getStringExtra("pass");
        email = intent.getStringExtra("email");
        isTea = intent.getBooleanExtra("isTea", false);
        isMilk = intent.getBooleanExtra("isMilk", false);
        isSugar = intent.getBooleanExtra("isSugar", false);
        isLemon = intent.getBooleanExtra("isLemon", false);
        drinkItem = intent.getIntExtra("drink", -1);
    }

    @Override
    public void onClick(View v) {
        intendToSendEmail();
        Toast.makeText(this,"Заказ отправлен на почту",Toast.LENGTH_SHORT).show();
    }

    private void intendToSendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        //Кому
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        //Заголовок
        String email_extra = "Заказ №: " + orderNumber + "от " + todayDate;
        intent.putExtra(Intent.EXTRA_SUBJECT, email_extra);
        //Текст
        intent.putExtra(Intent.EXTRA_TEXT, stringHeader+"\n"+detailOrder);
        startActivity(intent);
    }
}