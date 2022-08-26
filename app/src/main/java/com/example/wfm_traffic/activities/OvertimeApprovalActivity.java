package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.OverTimeAdapter;
import com.example.wfm_traffic.model.TaskModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tarek360.animated.icons.AnimatedIconView;
import tarek360.animated.icons.IconFactory;

public class OvertimeApprovalActivity extends AppCompatActivity {
    AppCompatButton Button,button1,button2,button3,button4;
    RecyclerView assigned_task_rv;
    ArrayList<TaskModel> taskModels;
    TextView title;


    final Calendar myCalendar= Calendar.getInstance();
    TextView textViewDate,textViewDate2;
    int hour, minute;

    String[] spinRecom = {"Recommended", "Not Recommended"};
Spinner spinnerRecom1,spinnerrecom2;
RelativeLayout relativeLayoutdate1,relativeLayoutdate2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overtime_approval);
spinnerRecom1=findViewById(R.id.recommentation1_spinner);
spinnerrecom2=findViewById(R.id.recommentation2_spinner);
textViewDate=findViewById(R.id.date_textview);
textViewDate2=findViewById(R.id.date2_textview);
       relativeLayoutdate1=findViewById(R.id.date_layout1);
        relativeLayoutdate2=findViewById(R.id.date_layout2);

        addition();

        title=findViewById(R.id.title);
        title.setText("Overtime Approval");
        ImageView backarrow=findViewById(R.id.imgBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AnimatedIconView imageViewNotification=findViewById(R.id.notification);
        imageViewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MessagesActivity.class);
                startActivity(intent);
            }
        });
        imageViewNotification.startAnimation(AnimationUtils.loadAnimation(this,R.anim.shake));
        imageViewNotification.setAnimatedIcon(IconFactory.iconNotificationAlert().setNotificationCount(3));

        imageViewNotification.startAnimation();



        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }

        };
        DatePickerDialog.OnDateSetListener date2 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel2();
            }

        };


        relativeLayoutdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(OvertimeApprovalActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        relativeLayoutdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(OvertimeApprovalActivity.this,date2,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                spinRecom);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                spinRecom);

        // set simple layout resource file
        // for each item of spinner
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinnerRecom1.setAdapter(ad);
        spinnerrecom2.setAdapter(ad2);

        spinnerRecom1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerrecom2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        assigned_task_rv = findViewById(R.id.assigned_task_recyclerview);
        assigned_task_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        assigned_task_rv.setAdapter(new OverTimeAdapter(taskModels,getApplicationContext()));
        Button = findViewById(R.id.rect);
        button1 = findViewById(R.id.rect1);

        button2 = findViewById(R.id.rect2);
        button3 = findViewById(R.id.rect3);
        button4 = findViewById(R.id.rect4);


        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                Button.setBackground(getDrawable(R.drawable.rect1));
                Button.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button1.setBackground(getDrawable(R.drawable.rect1));
                button1.setTextColor(Color.parseColor("#FFFFFF"));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button2.setBackground(getDrawable(R.drawable.rect1));
                button2.setTextColor(Color.parseColor("#FFFFFF"));

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button3.setBackground(getDrawable(R.drawable.rect1));
                button3.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button4.setBackground(getDrawable(R.drawable.rect1));
                button4.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }

    public void  intButton(){
        Button.setBackground(getDrawable(R.drawable.rect));
        button1.setBackground(getDrawable(R.drawable.rect));
        button2.setBackground(getDrawable(R.drawable.rect));
        button3.setBackground(getDrawable(R.drawable.rect));
        button4.setBackground(getDrawable(R.drawable.rect));
        Button.setTextColor(Color.parseColor("#7A5299"));
        button1.setTextColor(Color.parseColor("#7A5299"));
        button2.setTextColor(Color.parseColor("#7A5299"));
        button3.setTextColor(Color.parseColor("#7A5299"));
        button4.setTextColor(Color.parseColor("#7A5299"));

    }
    public void addition(){
        taskModels=new ArrayList<>();
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));
        taskModels.add(new TaskModel(987444, "Annual Leave (AL)", "13/04/2017","19/04/2017", "28/04/2017", "10", "00:00"));


    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel2(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate2.setText(dateFormat.format(myCalendar.getTime()));
    }
}