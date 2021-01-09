package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    public static final String SETUP_PROFILE = "setupProfile";

    private FloatingActionButton floatingActionButton;

    private FirebaseAuth mAuth;


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);

        mAuth = FirebaseAuth.getInstance();


        final Spinner spinnerGen = findViewById(R.id.setupProfileGenre);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.profileGenres, R.layout.support_simple_spinner_dropdown_item);
        spinnerGen.setAdapter(adapter);

        final EditText profileEmail = findViewById(R.id.setupProfileEmail);
        final EditText profilePassword = findViewById(R.id.setupProfilePassword);
        final EditText profileFullName = findViewById(R.id.setupProfileName);
        final EditText profileBDate = findViewById(R.id.setupProfileBDate);
        final EditText profileAge = findViewById(R.id.setupProfileAge);
        final EditText profileWeight = findViewById(R.id.setupProfileWeight);
        final EditText profileHeight = findViewById(R.id.setupProfileHeight);

        final String DATE_FORMAT = "DD/MM/YYYY";

        floatingActionButton = findViewById(R.id.setupProfileFinishBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(profileEmail.getText().toString().isEmpty())
                    profileEmail.setError("Introduceti un email");
                else
                if(profilePassword.getText().toString().isEmpty())
                    profilePassword.setError("Introduceti Parola");
                else
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

                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);

                    try {
                        sdf.parse(profileBDate.getText().toString());

                        final String email = profileEmail.getText().toString();
                        final String password = profilePassword.getText().toString();
                        final String fullName = profileFullName.getText().toString();
                        final Date bDate = new Date(profileBDate.getText().toString());
                        final Gen gen = Gen.valueOf(spinnerGen.getSelectedItem().toString().toUpperCase());
                        final int age = Integer.parseInt(profileAge.getText().toString());
                        final float weight = Float.parseFloat(profileWeight.getText().toString());
                        final float height = Float.parseFloat(profileHeight.getText().toString());

                        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Profile profile = new Profile(email, fullName, bDate, gen, age, weight, height, null);
                                    putProfileInFirebase(profile);
                                }
                            }
                        });
                        
//                        setResult(210, intent);
//                        finish();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void putProfileInFirebase(final Profile profile)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://proiect21.firebaseio.com/");
        DatabaseReference myRef = database.getReference("users");

        myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(profile)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "The user has been registered successfuly!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "User registration has failed", Toast.LENGTH_LONG).show();
                        }
                    }
        });
    }
}












