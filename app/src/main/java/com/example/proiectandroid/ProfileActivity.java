package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Intent intent = getIntent();

        final EditText profileName = findViewById(R.id.profileName);
        final EditText profileBDate = findViewById(R.id.profileBDate);
        final EditText profileAge = findViewById(R.id.profileAge);
        final EditText profileGenre = findViewById(R.id.profileGenre);
        final EditText profileWeight = findViewById(R.id.profileWeight);
        final EditText profileHeight = findViewById(R.id.profileHeight);


        if(intent.hasExtra(MainActivity.SHOW_PROFILE))
        {
            final String DATE_FORMAT = "dd/MM/yyyy";

            Profile profile = (Profile) intent.getSerializableExtra(MainActivity.SHOW_PROFILE);
            profileName.setText(profile.getFullName());
            profileBDate.setText(new SimpleDateFormat(DATE_FORMAT, Locale.US).format(profile.getbDate()));
            profileAge.setText(String.valueOf(profile.getAge()));
            profileGenre.setText(String.valueOf(Gen.valueOf(profile.getGen().toString().toUpperCase())));
            profileWeight.setText(String.valueOf(profile.getWeight()));
            profileHeight.setText(String.valueOf(profile.getHeight()));


        }
    }
}