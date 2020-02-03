package com.telran.a03_02_20_hw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final EditText inputEmail = findViewById(R.id.inputEmail);
        Button backBtn = findViewById(R.id.backBtn);
        Button nextBtn = findViewById(R.id.nextBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        EmailActivity.this,
                        PasswordActivity.class);
                intent.putExtra("EMAIL",
                        inputEmail.getText().toString());
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                setResult(RESULT_OK,data);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
