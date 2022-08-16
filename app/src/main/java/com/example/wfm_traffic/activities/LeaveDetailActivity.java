package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.LeaveAdapter;
import com.example.wfm_traffic.adapter.LeaveDetailAdapter;
import com.example.wfm_traffic.model.TaskModel;

import java.util.ArrayList;

public class LeaveDetailActivity extends AppCompatActivity {

    AppCompatButton Button,button1,button2,button3,button4;
    RecyclerView assigned_task_rv;
    ArrayList<TaskModel> taskModels;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_detail);

        addition();

        title=findViewById(R.id.title);
        title.setText("Leave Detail");
        ImageView backarrow=findViewById(R.id.imgBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        assigned_task_rv = findViewById(R.id.assigned_task_recyclerview);
        assigned_task_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        assigned_task_rv.setAdapter(new LeaveDetailAdapter(taskModels,getApplicationContext()));
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