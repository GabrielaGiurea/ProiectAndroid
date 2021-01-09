package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SleepActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

   private  TextView txtSleepTime;
    private Button btnStartDate;
    private Button btnStopDate;
    private Button btnAddSleep;

    private Button pressedButton;
    private String startDate;
    private String stopDate;

    SimpleDateFormat dateFormatter;

    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        dateFormatter =new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.txtSleepTime = findViewById(R.id.txtSleepTime);
        this.btnStartDate = findViewById(R.id.btnStartSleep);
        this.btnStopDate = findViewById(R.id.btnStopSleep);
        this.btnAddSleep= findViewById(R.id.btnAddSleep);

        this.btnAddSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = Database.getInstance(SleepActivity.this);

                Sleep sleep = new Sleep(startDate, stopDate);
                if (sleep.getId() == 0) {
                    db.sleepDao().insertSleeps(sleep);
                } else {
                    db.sleepDao().updateSleeps(sleep);

                }

              List<Sleep> sleepList =  db.sleepDao().getAllSleeps();
            }
        });

        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedButton = (Button)v;
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SleepActivity.this, SleepActivity.this,year, month,day);
                datePickerDialog.show();
            }
        };
        this.btnStartDate.setOnClickListener(onClickListener);
        this.btnStopDate.setOnClickListener(onClickListener);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        myYear = year;
        myday = day;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(SleepActivity.this, SleepActivity.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;

        String stringToParse;
        stringToParse = myday + "-" + myMonth + "-" + myYear + " "+ myHour +":"+ myMinute;

        if(pressedButton == btnStartDate){
            txtSleepTime.setText("");


                startDate = stringToParse;

        }

        StringBuffer sb = new StringBuffer();
        sb.append(txtSleepTime.getText());

        if(pressedButton == btnStopDate){
            sb.append("-> ");
                //stopDate = dateFormatter.parse(stringToParse);
                stopDate=stringToParse;

        }

        sb.append(myYear);
        sb.append(" - ");
        sb.append(myday);
        sb.append(" ");
        sb.append(myHour);
        sb.append(":");
        sb.append(myMinute);

        txtSleepTime.setText(sb.toString());
    }
}