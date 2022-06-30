package com.example.wfm_traffic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.wfm_traffic.adapter.ExpandableListAdapter;
import com.example.wfm_traffic.adapter.NavItemAdapter;
import com.example.wfm_traffic.model.MenuModel;
import com.example.wfm_traffic.model.NavItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView drawer_left;
    private DrawerLayout drawer;
    LinearLayout firstDrawer;
    RelativeLayout emlm;
    ListView secondDrawer;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    View viewHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        expandableListView = findViewById(R.id.expandableListView);
//        NavigationView navigationView = findViewById(R.id.nav_view);

        viewHeader = navigationView.getHeaderView(0);
//        ImageView imageViewNavheaderPRofile = (ImageView) viewHeader.findViewById(R.id.nav_header_profile_imageview);
//        ImageView imageViewNavheaderLogout = (ImageView) viewHeader.findViewById(R.id.nav_header_logout_iv);
        prepareMenuData();
        populateExpandableList();



        drawer_left=(ImageView) findViewById(R.id.imgBackArrow);
//        drawer = findViewById(R.id.drawer_layout);
//        firstDrawer = findViewById(R.id.drawer);
//        secondDrawer = findViewById(R.id.left_drawer);
//        emlm = findViewById(R.id.emlm);
//        emlm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawer.closeDrawer(GravityCompat.START);
//            }
//        });
//
        drawer_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    private void populateExpandableList() {
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel(R.drawable.dashboard,"Dashboard", true, false); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }
        menuModel = new MenuModel(R.drawable.dashboard,"Task",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel(R.drawable.calendar,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Assigned Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Approve Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Add Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Time Sheet", false, false);
        childModelsList.add(childModel);




        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel(R.drawable.dashboard,"Fines",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel(R.drawable.calendar,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Add Fines", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Fines", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
        childModelsList = new ArrayList<>();
        menuModel = new MenuModel(R.drawable.dashboard,"Leaves",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel(R.drawable.calendar,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Request Leave", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Leave Detail", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Approve Leave", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
        menuModel = new MenuModel(R.drawable.dashboard,"Overtime",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);

        childModel = new MenuModel(R.drawable.calendar,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Overtimes", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Overtimes List", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Overtimes Approval", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }



    }
//    public void ClickNavigation(View view){
//        // create a arraylist of the type NumbersView
//        final ArrayList<NavItem> arrayList = new ArrayList<NavItem>();
//
//        // add all the values from 1 to 15 to the arrayList
//        // the items are of the type NumbersView
//        arrayList.add(new NavItem("Calendar", "calendar"));
//        arrayList.add(new NavItem("Assigned Tasks", "calendar"));
//        arrayList.add(new NavItem("Approve Tasks", "calendar"));
//        arrayList.add(new NavItem("Add Taks", "calendar"));
//
//
//        // Now create the instance of the NumebrsViewAdapter and pass
//        // the context and arrayList created above
//        NavItemAdapter numbersArrayAdapter = new NavItemAdapter(this, arrayList);
//
//        // create the instance of the ListView to set the numbersViewAdapter
//        secondDrawer = findViewById(R.id.left_drawer);
//
//        // set the numbersViewAdapter for ListView
//        secondDrawer.setAdapter(numbersArrayAdapter);
////        secondDrawer.setVisibility(View.VISIBLE);
//        drawer.closeDrawer(firstDrawer);
//        drawer.openDrawer(secondDrawer);
//    }
}