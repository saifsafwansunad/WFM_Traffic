package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.AssignedTaskAdapter;
import com.example.wfm_traffic.model.TaskModel;

import java.util.ArrayList;

public class AssignedTaskActivity extends AppCompatActivity {

    AppCompatButton Button,button1,button2,button3,button4;
    RecyclerView assigned_task_rv;
    ArrayList<TaskModel>taskModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigned_task);

        addition();

        assigned_task_rv = findViewById(R.id.assigned_task_recyclerview);
        assigned_task_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        assigned_task_rv.setAdapter(new AssignedTaskAdapter(taskModels,getApplicationContext()));
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
        taskModels.add(new TaskModel(1, "patrol duty", "categ 1","Ari satogu", "1/27/98", "20:40", "00:00"));
        taskModels.add(new TaskModel(2, "point duty", "categ 1","xian matasuki", "1/27/98", "10:40", "00:00"));
        taskModels.add(new TaskModel(3, "Special duty", "categ 1","kasma satogu", "1/27/98", "15:40", "00:00"));
        taskModels.add(new TaskModel(4, "patrol duty", "categ 1","Ari satoshi", "1/27/98", "23:40", "05:00"));
        taskModels.add(new TaskModel(5, "special duty", "categ 1","Ari satogu", "1/27/98", "20:40", "00:00"));
        taskModels.add(new TaskModel(6, "patrol duty", "categ 1","Ari satogu", "1/27/98", "20:40", "00:00"));
        taskModels.add(new TaskModel(7, "special duty", "categ 1","Ari satogu", "1/27/98", "20:40", "00:00"));
        taskModels.add(new TaskModel(8, "patrol duty", "categ 1","Ari satogu", "1/27/98", "20:40", "00:00"));

    }
}