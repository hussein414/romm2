package com.googel.romm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegiterActivity extends AppCompatActivity {

    //item Introduction
    EditText user_id,password,name;
    Button btn_register;
    //................
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);
        findById();
        btn_register.setOnClickListener(v -> {
            //Creating user Entity
            UserEntity userEntity=new UserEntity();
            userEntity.setPassword(password.getText().toString());
            userEntity.setUserId(user_id.getText().toString());
            userEntity.setName(name.getText().toString());
            if (validateInput(userEntity)){
                //Do insert operation
                UserDatabase userDatabase=UserDatabase.getInstance(getApplicationContext());
                //initialize userDao
                UserDao userDao=userDatabase.userDao();
                //Do insert operation thread
                new Thread(() -> {
                    //call register  method
                    userDao.RegisterUser(userEntity);
                    runOnUiThread(() -> {
                        Toast.makeText(getApplicationContext(), "Register data", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegiterActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    });
                }).start();
            }else {
                //
                Toast.makeText(this, "fill all filed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    //Verify input validation
    private Boolean validateInput(UserEntity  userEntity){
     if (userEntity.getName().isEmpty()||userEntity.getPassword().isEmpty()||userEntity.getUserId().isEmpty()){
         return false;
     }
     return true;
    }
    //........................
    // find by id for item
    public void findById() {
        user_id = findViewById(R.id.txt_user_id);
        name = findViewById(R.id.txt_name);
        password = findViewById(R.id.txt_password);
        btn_register = findViewById(R.id.btn_register);
    }
    //..................

}