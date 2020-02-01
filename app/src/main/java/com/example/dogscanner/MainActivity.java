package com.example.dogscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText userName, userPassword;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final String uname= "admin";
        final String pass= "admin123";
        userName = (EditText)findViewById(R.id.edtEmail);
        userPassword = (EditText)findViewById(R.id.edtPassword);
         btnLogin= (Button) findViewById(R.id.btnLogin);

         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(userName.getText().toString().equals(uname) && userPassword.getText().toString().equals(pass))
                 {
                     Intent i = new Intent(getApplicationContext(), Search.class);
                     startActivity(i);
                 } else
                 {
                     Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                 }
             }
         });

        }
    }

