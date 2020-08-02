package com.example.bnn_news.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bnn_news.MainActivity;
import com.example.bnn_news.R;

public class Login_Activity extends AppCompatActivity {
    EditText email,password;
    Button btnlogin;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
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


    }

}
