package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String SETUP_PROFILE = "setupProfile";

    public static final int REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // if no profile then
        Log.e("msg", "opened");
        Intent intent = new Intent(this, setupProfile.class);
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 200:
                if(resultCode == 210) {
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