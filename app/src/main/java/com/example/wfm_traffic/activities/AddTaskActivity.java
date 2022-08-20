package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.wfm_traffic.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity  {


    String[] taskcategory = {"Task Category 1", "Task Category 2",
            "Task Category 3", "Task Category 4",
            "Task Category 5", "Task Category 6"};

    String[] asignedto = {"Self", "Staff Memeber 1",
            "Staff Memeber 3", "Staff Memeber 4",
            "Staff Memeber 5"};

    String[] status = {"Not Started", "In Progress",
            "Completed","Deferred To","waiting on Someone else"};

    String[] priority =  {"1-High", "2-Normal",
            "3-Low"};

    final Calendar myCalendar= Calendar.getInstance();
    TextView textViewDate,textViewFromTime,textViewToTime;
    int hour, minute;
RelativeLayout relativeLayoutFromTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Spinner spin = findViewById(R.id.taskcategory_spinner);
        Spinner spinnerAssgine = findViewById(R.id.assigned_to_spinner);
        Spinner spinnerstatus = findViewById(R.id.status_spinner);
        Spinner spinnerpriority = findViewById(R.id.priority_spinner);
        RelativeLayout relativeLayoutDate=findViewById(R.id.date_layout);
        relativeLayoutFromTime=findViewById(R.id.from_time_relativelayout);
        textViewFromTime=findViewById(R.id.from_time_textview);
        textViewToTime=findViewById(R.id.to_time_textview);

        textViewDate=findViewById(R.id.date_textview);
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
                new DatePickerDialog(AddTaskActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });





        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                taskcategory);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                asignedto);

        // set simple layout resource file
        // for each item of spinner
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);



        ArrayAdapter ad3
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                status);

        // set simple layout resource file
        // for each item of spinner
        ad3.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        ArrayAdapter ad4
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                priority);

        // set simple layout resource file
        // for each item of spinner
        ad4.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        spinnerAssgine.setAdapter(ad2);
        spinnerAssgine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerstatus.setAdapter(ad3);
        spinnerstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerpriority.setAdapter(ad4);
        spinnerpriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method


//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//        Toast.makeText(getApplicationContext(),
//                courses[position],
//                Toast.LENGTH_LONG)
//                .show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

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
                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}
