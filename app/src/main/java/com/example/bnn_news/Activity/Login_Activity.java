package com.example.bnn_news.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bnn_news.APIs.UserApi;
import com.example.bnn_news.BLL.UserBLL;
import com.example.bnn_news.MainActivity;
import com.example.bnn_news.Models.UserModel;
import com.example.bnn_news.R;
import com.example.bnn_news.Utlis.Helpers;

public class Login_Activity extends AppCompatActivity {
    EditText email,password;
    private UserBLL userBLL;
    Button btnlogin;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userBLL=new UserBLL();
        email=findViewById(R.id.emaillog);
        password=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnlogin);
        register=findViewById(R.id.logreg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_Activity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }
    private void signIn(){
        Helpers.StrictMode();
        String emaillog=email.getText().toString();
        String passwordlog=password.getText().toString();
        UserModel authUser=userBLL.loginUser(emaillog,passwordlog);
        if(authUser!=null){
            Intent intent=new Intent(Login_Activity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }
}
