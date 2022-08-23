package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.wfm_traffic.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OvertimesActivity extends AppCompatActivity {



    final Calendar myCalendar= Calendar.getInstance();
    TextView textViewDate,textViewFromTime,textViewToTime;
    int hour, minute;
Spinner spinnerDayofweek;
    String[] dayofweeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overtimes);
        Spinner spinDayofweek = findViewById(R.id.dayofwekspinner);
        RelativeLayout relativeLayoutDate=findViewById(R.id.date_layout);
        textViewFromTime=findViewById(R.id.from_time_textview);
        textViewToTime=findViewById(R.id.to_time_textview);
        title=findViewById(R.id.title);
        title.setText("Overtimes");
        textViewDate=findViewById(R.id.date_textview);

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                dayofweeek);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        spinDayofweek.setAdapter(ad);
        spinDayofweek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),
//                courses[i],
//                Toast.LENGTH_LONG)
//                .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }

        };

        relativeLayoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(OvertimesActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                textViewFromTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
//                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);
//        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();

    }

    public void popTimePickerTo(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
//                textViewFromTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);
//        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();

    }
}