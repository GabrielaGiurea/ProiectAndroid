package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView headline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemProfile:
                startActivityForResult(new Intent(MainActivity.this, ProfileActivity.class), 200);
                break;
            case R.id.menuItemAliments:
                startActivity(new Intent(MainActivity.this, MealsActivity.class));
                break;
            case R.id.menuItemSleep:
                startActivity(new Intent(MainActivity.this, SleepActivity.class));
                break;
            case R.id.menuItemPA:
                startActivity(new Intent(MainActivity.this, SportActivity.class));
                break;
            case R.id.menuItemLogOut:
                userLogOut();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_CANCELED) {
            if(requestCode == 200) {
                Profile profile = (Profile) data.getExtras().getSerializable("profile");
                headline = findViewById(R.id.mainHeadline);
                headline.setText("Salut, " + profile.getFullName());
            }
        }

    }

    private void userLogOut() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Toast.makeText(MainActivity.this, "Ai fost deconectat", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, StartActivity.class));
    }
}