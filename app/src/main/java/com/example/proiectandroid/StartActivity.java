package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        register = (Button) findViewById(R.id.startRegister);
        register.setOnClickListener(this);

        login = (Button) findViewById(R.id.startLogin);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.startLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            default:
                break;
        }
    }
}