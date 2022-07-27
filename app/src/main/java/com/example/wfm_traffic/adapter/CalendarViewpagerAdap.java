package com.example.wfm_traffic.adapter;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wfm_traffic.fragments.DaywiseFragment;
import com.example.wfm_traffic.fragments.ListWiseFragment;
import com.example.wfm_traffic.fragments.MonthWiseFragment;
import com.example.wfm_traffic.fragments.WeekWiseFragment;

public class CalendarViewpagerAdap extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public CalendarViewpagerAdap(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        Log.d("asasas" , position + "");
        switch (position) {
            case 0:
                MonthWiseFragment adminMessageFragment = new MonthWiseFragment();
                return adminMessageFragment;
            case 1:
                WeekWiseFragment userMessageFragment = new WeekWiseFragment();
                return userMessageFragment;
            case 2:
                DaywiseFragment daywiseFragment = new DaywiseFragment();
                return daywiseFragment;
            case 3:
                ListWiseFragment listWiseFragment = new ListWiseFragment();
                return listWiseFragment;


            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
