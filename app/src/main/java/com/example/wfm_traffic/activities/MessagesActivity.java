package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.AssignedTaskAdapter;
import com.example.wfm_traffic.adapter.MessagesAdapter;
import com.example.wfm_traffic.adapter.OverTimeAdapter;
import com.example.wfm_traffic.model.MessagesModel;
import com.example.wfm_traffic.model.TaskModel;

import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {
RecyclerView recyclerViewMsgs;
    ArrayList<MessagesModel> messagesModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        recyclerViewMsgs=findViewById(R.id.messages_recyclerview);
       TextView title=findViewById(R.id.title);
        title.setText("Messages");
        ImageView backarrow=findViewById(R.id.imgBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        ImageView imageViewNotification=findViewById(R.id.notification);
//        imageViewNotification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),MessagesActivity.class);
//                startActivity(intent);
//            }
//        });
//        imageViewNotification.startAnimation(AnimationUtils.loadAnimation(this,R.anim.shake));

        messagesModels=new ArrayList<>();
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.profile,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewMsgs.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewMsgs.setAdapter(new MessagesAdapter(messagesModels, getApplicationContext()));
//        assigned_task_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        assigned_task_rv.setAdapter(new OverTimeAdapter(taskModels,getApplicationContext()));
    }
//
//    public void messages(){
//        messagesModels=new ArrayList<>();
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
//        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));



}