package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wfm_traffic.R;
import com.google.android.material.button.MaterialButton;

import tarek360.animated.icons.AnimatedIconView;
import tarek360.animated.icons.IconFactory;

public class TimeSheetActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);

        title=findViewById(R.id.title);
        title.setText("Daily Time Sheet");
        ImageView backarrow=findViewById(R.id.imgBackArrow);
        MaterialButton materialButtonSubmit=findViewById(R.id.submit_btn);

        materialButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(TimeSheetActivity.this, "Submited Successfully", Toast.LENGTH_SHORT).show();
            }
        });
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

    }
}