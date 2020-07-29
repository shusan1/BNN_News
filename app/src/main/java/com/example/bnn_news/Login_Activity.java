package com.example.bnn_news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email=findViewById(R.id.emaillog);
        password=findViewById(R.id.password);
    }
}
