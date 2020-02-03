package com.telran.a03_02_20_hw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView emailTxt, passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.loginBtn);
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    EmailActivity.class
            );
            startActivityForResult(intent, 1);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                String email = data.getStringExtra("EMAIL");
                String password = data.getStringExtra("PASSWORD");
                emailTxt.setText("Email: " + email);
                passwordTxt.setText("Password: " + password);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
