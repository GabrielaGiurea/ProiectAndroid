package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MealsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mealsBreakfast, mealsLaunch, mealsSnacks, mealsDinner;
    private Button addMeals;

    private String FILE_NAME = "mealsJson.json";

    private ArrayList<Meals> MealsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        addMeals = (Button) findViewById(R.id.mealsAddButton);
        addMeals.setOnClickListener(this);
        mealsBreakfast = findViewById(R.id.mealsBreakfast);
        mealsLaunch = findViewById(R.id.mealsLaunch);
        mealsSnacks = findViewById(R.id.mealsSnacks);
        mealsDinner = findViewById(R.id.mealsDinner);

        MealsList = new ArrayList<Meals>();

    }

    private void saveMealsEntity() {

        Log.e("msg", "save meals begin");
        Meals meals = new Meals(Float.parseFloat(mealsBreakfast.getText().toString()),
                Float.parseFloat(mealsLaunch.getText().toString()),
                Float.parseFloat(mealsSnacks.getText().toString()),
                Float.parseFloat(mealsDinner.getText().toString())
        );

        try {
            FileReader fileReader = new FileReader(new File(getApplicationContext().getFilesDir(), FILE_NAME));

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            String response = stringBuilder.toString();
            Log.e("json:", response);
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONObject mealsArrayFromJson = jsonObject.getJSONObject("meals");
                if(mealsArrayFromJson != null) {
                    String id = "0";
                    while (mealsArrayFromJson.get(id) != null) {
                        JSONObject mealsJson = new JSONObject(mealsArrayFromJson.get(id).toString());
                        Meals tempMeals = new Meals(Float.parseFloat(mealsJson.get("breakfast").toString()),
                                Float.parseFloat(mealsJson.get("launch").toString()),
                                Float.parseFloat(mealsJson.get("snacks").toString()),
                                Float.parseFloat(mealsJson.get("dinner").toString())
                        );
                        MealsList.add(tempMeals);
                        id = String.valueOf(Integer.parseInt(id) + 1);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject mealsJson = new JSONObject();

        MealsList.add(meals);

        try {
            for(int i = 0; i < MealsList.size(); i++) {
                JSONObject mealsItem = new JSONObject();
                mealsItem.put("breakfast", String.valueOf(meals.getBreakfast()));
                mealsItem.put("launch", String.valueOf(meals.getLunch()));
                mealsItem.put("snacks", String.valueOf(meals.getSnack()));
                mealsItem.put("dinner", String.valueOf(meals.getDinner()));

                JSONObject mealsItemId = new JSONObject();
                mealsItemId.put(String.valueOf(i), mealsItem);

                mealsJson.accumulate("meals", mealsItemId);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            File file = new File(getApplicationContext().getFilesDir(), FILE_NAME);

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(mealsJson.toString());
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.mealsAddButton:
                saveMealsEntity();
                break;
        }
    }
}