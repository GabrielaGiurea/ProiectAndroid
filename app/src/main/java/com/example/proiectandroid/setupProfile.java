package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class setupProfile extends AppCompatActivity {

    public static final String SETUP_PROFILE = "setupProfile";

    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);

        final Spinner spinnerGen = findViewById(R.id.setupProfileGenre);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.profileGenres, R.layout.support_simple_spinner_dropdown_item);

        spinnerGen.setAdapter(adapter);

        final EditText profileFullName = findViewById(R.id.setupProfileName);
        final EditText profileBDate = findViewById(R.id.setupProfileBDate);
        final EditText profileAge = findViewById(R.id.setupProfileAge);
        final EditText profileWeight = findViewById(R.id.setupProfileWeight);
        final EditText profileHeight = findViewById(R.id.setupProfileHeight);

        final String DATE_FORMAT = "DD/MM/YYYY";

        floatingActionButton = findViewById(R.id.setupProfileFinishBtn);

        Log.e("msg", "before getIntent");

        final Intent intent = getIntent();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(profileFullName.getText().toString().isEmpty())
                    profileFullName.setError("Introduceti Numele");
                else
                if (profileBDate.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Introduceti data nasterii", Toast.LENGTH_LONG).show();
                else
                if(profileAge.getText().toString().isEmpty())
                    profileAge.setError("Introduceti varsta");
                else
                if(profileWeight.getText().toString().isEmpty())
                    profileWeight.setError("Introduceti greutatea corporala");
                else
                if(profileHeight.getText().toString().isEmpty())
                    profileHeight.setError("Introduceti inaltimea dvs.");
                else
                {
                    // creare obiect

                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);

                    try {
                        sdf.parse(profileBDate.getText().toString());

                        String fullName = profileFullName.getText().toString();
                        Date bDate = new Date(profileBDate.getText().toString());
                        Gen gen = Gen.valueOf(spinnerGen.getSelectedItem().toString().toUpperCase());
                        int age = Integer.parseInt(profileAge.getText().toString());
                        float weight = Float.parseFloat(profileWeight.getText().toString());
                        float height = Float.parseFloat(profileHeight.getText().toString());

                        Profile profile = new Profile(fullName, bDate, gen, age, weight, height);

                        Log.e("msg", "before putExtra");
                        intent.putExtra(SETUP_PROFILE, profile);
                        setResult(210, intent);
                        finish();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



    }
}












