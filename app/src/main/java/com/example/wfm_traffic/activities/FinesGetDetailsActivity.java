package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.FinesTabAdapter;
import com.google.android.material.tabs.TabLayout;

public class FinesGetDetailsActivity extends AppCompatActivity {
    TabLayout tabLayoutFines;
    ViewPager viewPagerFines;
    Button buttonClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fines_get_details);
        tabLayoutFines=(TabLayout)findViewById(R.id.tabLayout);
        viewPagerFines=(ViewPager)findViewById(R.id.viewPager);
        buttonClose=findViewById(R.id.close_btn);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tabLayoutFines.addTab(tabLayoutFines.newTab().setText("Driver"));
        tabLayoutFines.addTab(tabLayoutFines.newTab().setText("Vehicle"));
        tabLayoutFines.addTab(tabLayoutFines.newTab().setText("License"));
        tabLayoutFines.addTab(tabLayoutFines.newTab().setText("Fine"));

        tabLayoutFines.setTabGravity(TabLayout.GRAVITY_FILL);

        final FinesTabAdapter adapter = new FinesTabAdapter(this,getSupportFragmentManager(), tabLayoutFines.getTabCount());
        viewPagerFines.setAdapter(adapter);

        viewPagerFines.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutFines));

        tabLayoutFines.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerFines.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}