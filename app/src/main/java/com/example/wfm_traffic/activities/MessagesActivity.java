package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.AssignedTaskAdapter;
import com.example.wfm_traffic.adapter.MessagesAdapter;
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
        recyclerViewMsgs.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewMsgs.setAdapter(new MessagesAdapter(messagesModels,getApplicationContext()));
        messages();
    }

    public void messages(){
        messagesModels=new ArrayList<>();
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));
        messagesModels.add(new MessagesModel(R.drawable.ic_launcher_background,"Jonathan","San Francisco USA","Software Engineer","SomeCompany Inc"));


    }
}