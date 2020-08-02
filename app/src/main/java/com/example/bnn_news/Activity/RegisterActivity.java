package com.example.bnn_news.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bnn_news.BLL.UserBLL;
import com.example.bnn_news.Models.UserModel;
import com.example.bnn_news.R;
import com.example.bnn_news.Utlis.Helpers;

public class RegisterActivity extends AppCompatActivity {
    EditText first, last, phone, email, password;
    Button btnregister;
    TextView loginback;
    UserBLL userBLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        first = findViewById(R.id.firstname);
        last = findViewById(R.id.lastname);
        phone = findViewById(R.id.phoneno);
        email = findViewById(R.id.emailreg);
        password = findViewById(R.id.passwordreg);
        btnregister = findViewById(R.id.btnreg);
        loginback = findViewById(R.id.backlogin);
        userBLL = new UserBLL();

        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        });


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        Helpers.StrictMode();
        String emailreg = email.getText().toString();
        String passwordreg = password.getText().toString();
        String firstname = first.getText().toString();
        String lastname = last.getText().toString();
        String phno = phone.getText().toString();
        UserModel authUser = userBLL.registerUser(emailreg, passwordreg, firstname, lastname, phno);
        if (authUser != null) {
            Toast.makeText(this, "Register Successfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();
        }

    }

}

