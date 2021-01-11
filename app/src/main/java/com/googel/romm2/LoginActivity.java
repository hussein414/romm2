package com.googel.romm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText login_user_id,login_password;
    Button btn_login;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findById();
        btn_login.setOnClickListener(v -> {
            // input validation
            final String UserIdtext = login_user_id.getText().toString();
            final String passwordtext = login_password.getText().toString();
            if (UserIdtext.isEmpty() || passwordtext.isEmpty()) {
                Toast.makeText(getApplicationContext(), "fill all filed !", Toast.LENGTH_SHORT).show();
            } else {
                //perform query
                UserDatabase userDatabase = UserDatabase.getInstance(getApplicationContext());
                UserDao userDao = userDatabase.userDao();
                new Thread(() -> {
                    //calling login method
                    UserEntity userEntity = userDao.login(UserIdtext, passwordtext);
                    if (userEntity==null){
                       runOnUiThread(() -> {
                           Toast.makeText(getApplicationContext(), " invalid credentials", Toast.LENGTH_SHORT).show();
                       });
                    }else{
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }
                }).start();
            }
        });
    }
    public void findById(){
       login_user_id=findViewById(R.id.txt_login_user_id);
        login_password=findViewById(R.id.txt_login_password);
        btn_login=findViewById(R.id.btn_loin2);

    }
}