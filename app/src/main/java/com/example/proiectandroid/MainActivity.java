package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

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
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
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

    private void userLogOut() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Toast.makeText(MainActivity.this, "Ai fost deconectat", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, StartActivity.class));
    }
}