package com.example.wfm_traffic.adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Context;
import android.os.Bundle;

import com.example.wfm_traffic.fragments.FinesTabFragments.FinesInfofragment;
import com.example.wfm_traffic.fragments.FinesTabFragments.LicenseInfoFragment;
import com.example.wfm_traffic.fragments.FinesTabFragments.PersonInfoFragment;
import com.example.wfm_traffic.fragments.FinesTabFragments.VehicleInfoFragment;

public class FinesTabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public FinesTabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PersonInfoFragment personInfoFragment = new PersonInfoFragment();
                return personInfoFragment;
            case 1:
                VehicleInfoFragment vehicleInfoFragment = new VehicleInfoFragment();
                return vehicleInfoFragment;
            case 2:
                LicenseInfoFragment licenseInfoFragment = new LicenseInfoFragment();
                return licenseInfoFragment;
            case 3:
                FinesInfofragment finesInfofragment = new FinesInfofragment();
                return finesInfofragment;
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