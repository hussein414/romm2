package com.googel.romm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //item Introduction
    Button btn_login,btn_register;
    //..........
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findbyid();
        btn_login.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });
        btn_register.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,RegiterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    //find by id view
    private void findbyid() {
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.click_register);
    }
}