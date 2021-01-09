package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseUser user;
    private DatabaseReference myRef;
    private String userId;

    private Profile profile;

    private EditText profileName, profileBDate, profileAge, profileGenre, profileWeight, profileHeight;
    private Spinner spinnerGen;
    private Button profileUpdate;
    private final String DATE_FORMAT = "dd/MM/yyyy";

    public ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.profileGenres, R.layout.support_simple_spinner_dropdown_item);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        database = FirebaseDatabase.getInstance("https://proiect21.firebaseio.com/");
        myRef = database.getReference("users");
        user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();

        profileName = findViewById(R.id.profileName);
        profileBDate = findViewById(R.id.profileBDate);
        profileAge = findViewById(R.id.profileAge);
        profileWeight = findViewById(R.id.profileWeight);
        profileHeight = findViewById(R.id.profileHeight);
        profileUpdate = (Button) findViewById(R.id.profileUpdate);
        profileUpdate.setOnClickListener(this);

        spinnerGen = findViewById(R.id.setupProfileGenre);
        spinnerGen.setAdapter(adapter);

        getCurrentUserProfileInfo();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.profileUpdate:
                updateCurrentUserProfileInfo();
                break;
        }
    }

    private void getCurrentUserProfileInfo() {
        myRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profile = snapshot.getValue(Profile.class);
                profile.setUuid(userId);
                profileName.setText(profile.getFullName());
                profileBDate.setText(new SimpleDateFormat(DATE_FORMAT, Locale.US).format(profile.getbDate()));
                profileAge.setText(String.valueOf(profile.getAge()));
//                spinnerGen.setSelection(adapter.getPosition(profile.getGen().toString()));
//                profileGenre.setText(String.valueOf(Gen.valueOf(profile.getGen().toString().toUpperCase())));
                profileWeight.setText(String.valueOf(profile.getWeight()));
                profileHeight.setText(String.valueOf(profile.getHeight()));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateCurrentUserProfileInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        try {
            sdf.parse(profileBDate.getText().toString());
        } catch (ParseException e) {
            Toast.makeText(ProfileActivity.this, "Formatul pentru dată este greșit", Toast.LENGTH_LONG).show();
        }

        profile.setFullName(profileName.getText().toString());
        profile.setAge(Integer.parseInt(profileAge.getText().toString()));
        profile.setbDate(new Date(profileBDate.getText().toString()));
//        profile.setGen(Gen.valueOf(profile.getGen().toString().toUpperCase()));
        myRef.child(userId).setValue(Profile.class).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ProfileActivity.this, "Profilul a fost actualizat cu succes!", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ProfileActivity.this, "Acutalizarea profilului a esuat", Toast.LENGTH_LONG).show();
            }
        });
    }
}