package com.example.redballtoy.layoutscafeorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreatedOrderActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private RadioButton rbTea, rbCofe;
    private CheckBox chooseMilk, chooseSugar, chooseLemon;
    boolean isTea = true;
    boolean isMilk = false;
    boolean isSugar = false;
    boolean isLemon = false;
    private Spinner drinkType;
    private Button createOrder;
    private int spinnerItemSelected;
    private String name;
    private String pass;
    private String email;
    private final String myLog = "myLog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_order);
        getIntentFromLogin();
        initialingUIelements();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_cofe:
                ifSelectCofe();
                break;
            case R.id.rb_tea:
                ifSelectTea();
                break;
            case R.id.cb_milk:
                isMilk = chooseMilk.isChecked();
                break;
            case R.id.cb_sugar:
                isMilk = chooseSugar.isChecked();
                break;
            case R.id.cb_lemon:
                isMilk = chooseLemon.isChecked();
                break;
            case R.id.bt_make_order:
                pressMakeOrder();
                break;

        }
        //Toast.makeText(this, checkedDrink, Toast.LENGTH_SHORT).show();
    }


    private void initialingUIelements() {
        //Check drink
        rbTea = findViewById(R.id.rb_tea);
        rbCofe = findViewById(R.id.rb_cofe);
        rbTea.setOnClickListener(this);
        rbCofe.setOnClickListener(this);

        //Check added
        chooseMilk = findViewById(R.id.cb_milk);
        chooseSugar = findViewById(R.id.cb_sugar);
        chooseLemon = findViewById(R.id.cb_lemon);
        chooseMilk.setOnClickListener(this);
        chooseLemon.setOnClickListener(this);
        chooseSugar.setOnClickListener(this);

        //Drinks type list
        drinkType = findViewById(R.id.sp_drink_type);
        drinkType.setOnItemSelectedListener(this);

        //Create order Button
        createOrder = findViewById(R.id.bt_make_order);
        createOrder.setOnClickListener(this);
    }

    private void getIntentFromLogin() {
        Intent intent = getIntent();
        //Проверка что интент содержит данные ключи
        if (!intent.hasExtra("name") || !intent.hasExtra("pass")
                || !intent.hasExtra("email")) {
            Toast.makeText(this, getString(R.string.err1), Toast.LENGTH_LONG).show();
            return;
        }
        name = intent.getStringExtra("name");
        pass = intent.getStringExtra("pass");
        email = intent.getStringExtra("email");

        String msg = getString(R.string.privet) + " " + name + getString(R.string.who_you_do);
        TextView tvOrderTitleTop = findViewById(R.id.tv_order_title_top);
        tvOrderTitleTop.setText(msg);
    }

    private void ifSelectTea() {
        isTea = true;
        chooseLemon.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapterTea = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tea_array));
        drinkType.setAdapter(adapterTea);
    }

    private void ifSelectCofe() {
        isTea = false;
        chooseLemon.setVisibility(View.INVISIBLE);
        chooseLemon.setChecked(false);
        ArrayAdapter<String> adapterCofe = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.kofe_array));
        drinkType.setAdapter(adapterCofe);
    }

    private void pressMakeOrder() {
        if (isAddOptionEmpty()) return;
        Intent intent = new Intent(this, OrderInfo.class);
        intent.putExtra("name", name);
        intent.putExtra("pass", pass);
        intent.putExtra("email", email);
        intent.putExtra("isTea", isTea);
        intent.putExtra("isMilk", isMilk);
        intent.putExtra("isSugar", isSugar);
        intent.putExtra("isLemon", isLemon);
        intent.putExtra("drink", spinnerItemSelected);
        startActivity(intent);
    }

    private boolean isAddOptionEmpty() {
        isMilk = chooseMilk.isChecked();
        isSugar = chooseSugar.isChecked();
        isLemon = chooseLemon.isChecked();

        if (!isMilk & !isLemon & !isSugar) {
            showMessageAdd();
            return true;
        }
        return false;
    }

    private void showMessageAdd() {
        if (rbTea.isChecked()) {
            Toast.makeText(this, getString(R.string.want_to_add)
                    + getString(R.string.tea).toLowerCase() + "?", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.want_to_add)
                    + getString(R.string.cofe).toLowerCase() + "?", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerItemSelected = position;
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}