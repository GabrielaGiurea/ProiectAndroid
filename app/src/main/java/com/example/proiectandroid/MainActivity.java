package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    public static final String SETUP_PROFILE = "setupProfile";

    public static final int REQUEST_CODE = 200;

    private Button btnProfile;

    private Button btnMeals;

    private Button btnSleep;

    private Button btnSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // if no profile then
        Log.e("msg", "opened");
        Intent intent = new Intent(this, setupProfile.class);
        startActivityForResult(intent, REQUEST_CODE);

        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        btnMeals = findViewById(R.id.btnMeals);
        btnMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MealsActivity.class);
                startActivity(intent);
            }
        });

        btnSleep = findViewById(R.id.btnSleep);
        btnMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SleepActivity.class);
                startActivity(intent);
            }
        });

        btnSport = findViewById(R.id.btnSport);
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SportActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 200:
                if (resultCode == 210) {
                    Profile profile = (Profile) data.getSerializableExtra(SETUP_PROFILE);

                    Log.e("log", profile.toString());

                }

                //mPresenter.getBookMixAToc(bookId, "chapters");
                break;
            default:
                break;
        }
    }
}