package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.LeaveAdapter;
import com.example.wfm_traffic.adapter.OverTimeAdapter;
import com.example.wfm_traffic.model.TaskModel;

import java.util.ArrayList;

public class OvertimeListActivity extends AppCompatActivity {

    AppCompatButton Button,button1,button2,button3,button4;
    RecyclerView assigned_task_rv;
    ArrayList<TaskModel> taskModels;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overtime_list);

        addition();

        title=findViewById(R.id.title);
        title.setText("Overtime List");
        ImageView backarrow=findViewById(R.id.imgBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
}