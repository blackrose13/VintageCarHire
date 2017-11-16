package com.vintagecarhire;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class HomeActivity extends AppCompatActivity {
    EditText location;
    EditText pick_up_date;
    EditText return_date;
    EditText time;
    Button vintage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        onClickButtonListener();

        //the code below initiate the views in the activity_home.xml file
        location = (EditText) findViewById(R.id.location);
        pick_up_date = (EditText) findViewById(R.id.pick_up_date);
        return_date = (EditText) findViewById(R.id.return_date);
        time = (EditText) findViewById(R.id.time);
        vintage = (Button) findViewById(R.id.vintage);

        //click listeners
        location.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                location.setBackgroundColor(Color.BLACK);
                location.getText().toString();
                EditText.setText("Your location is" + location.getText().toString() + "");
            }
    });

        pick_up_date.setOnClickListener(new View.OnClickListener(){
         public void onClick(View view) {

                                            }

         final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        ///date picker dialog initiation
        datePickerDialog = new DatePickerDialog(HomeActivity.this,
                new DatePickerDialog.onDateSetListener() {


                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        //user sets the pickup date in the edit text box
                        pick_up_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    ////user is requested to enter the return date of the vintage car


    return_date.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view);
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        ///date picker dialog initiation
        datePickerDialog = new DatePickerDialog(HomeActivity.this,
                new DatePickerDialog.onDateSetListener() {


                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        //user sets the pickup date in the edit text box
                        pick_up_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    })



    time.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTime TimePicker;
                TimePickerDialog mTimePicker = new TimePickerDialog(HomeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                                time.setText(selectedHour + ":" + selectedMinute);

                            }
                        }, hour, minute, true);
                mTimePicker.setTitle("Select Booking Time");
                mTimePicker.show();
            }

        });
    public void onClickButtonListener() {
        Button vintage_cars = (Button)findViewById(R.id.vintage);

        vintage_cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this,AvailableVintageCars.class);
                startActivity(intent);

            }
        });


    }
}
    }
}
