package com.telran.a03_02_20_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        final String email = getIntent().getStringExtra("EMAIL");
        final EditText inputPassword = findViewById(R.id.inputPassword);
        Button backBtn = findViewById(R.id.backBtn);
        Button okBtn = findViewById(R.id.okBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("EMAIL",email);
                data.putExtra("PASSWORD",
                        inputPassword.getText().toString());
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }
}
