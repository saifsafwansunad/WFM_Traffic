package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.core.ui.Legend;
import com.anychart.core.ui.Paginator;
import com.example.wfm_traffic.CardItem;
import com.example.wfm_traffic.R;
import com.example.wfm_traffic.ShadowTransformer;
import com.example.wfm_traffic.adapter.CardFragmentPagerAdapter;
import com.example.wfm_traffic.adapter.CardPagerAdapter;
import com.example.wfm_traffic.adapter.ExpandableListAdapter;
import com.example.wfm_traffic.chart.extensions.ChartExtensionsKt;
import com.example.wfm_traffic.chart.extensions.LineChartValue;
import com.example.wfm_traffic.chart.tooltip.SliderTooltip;

import com.example.wfm_traffic.databinding.ActivityMainBinding;
import com.example.wfm_traffic.databinding.HomePageBinding;
import com.example.wfm_traffic.model.MenuModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import kotlin.Triple;

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
    private  ActivityMainBinding binding;
    private SliderTooltip sliderTooltip;
    HomePageBinding homePageBinding;

    String[] strAr = {"Submitted", "Verified", "Approved","Rejected","IA Approved","IA Rejected"};
    int[] intvalues={501,300,204,165,128,117};
    AnyChartView anyChartViewPieChart;

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        homePageBinding= HomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sliderTooltip = new SliderTooltip();
        ActivityFunc fun = new ActivityFunc();
        fun.setupLinearChart(sliderTooltip,binding,getApplicationContext());
        fun.setupLinearChart1(sliderTooltip,binding,getApplicationContext());
        fun.setupLinearChart2(sliderTooltip,binding,getApplicationContext());
        fun.setupLinearChart3(sliderTooltip,binding,getApplicationContext());
anyChartViewPieChart=(AnyChartView)findViewById(R.id.piechart);
setupChartView();
//        setupLinearChart();
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1,R.mipmap.clipboard));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1,R.mipmap.approve_tasks));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1,R.mipmap.calendar));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1,R.mipmap.fine));
        mCardAdapter.addCardItem(new CardItem(R.string.title_5, R.string.text_1,R.mipmap.overtime));

        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

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

    private void setupChartView() {
Pie pie= AnyChart.pie();
       pie.legend(false);

List<DataEntry> datEntries=new ArrayList();
for (int i=0;i<strAr.length;i++){
    datEntries.add(new ValueDataEntry(strAr[i],intvalues[i]));
}
pie.data(datEntries);
anyChartViewPieChart.setChart(pie);
    }

//    private void setupLinearChart() {
//        // Chart data
//        Date currentDate = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(currentDate);
//        //Create a fake data for one month
//        HashMap<String, List<String>> remoteData = new HashMap<>();
//        remoteData.put("1", Arrays.asList("11"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("2", Arrays.asList("12"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("3", Arrays.asList("13"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("4", Arrays.asList("10"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("5", Arrays.asList("11"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("6", Arrays.asList("7"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("7", Arrays.asList("9"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("8", Arrays.asList("4"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("9", Arrays.asList("5"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("10", Arrays.asList("6"));
//        calendar.add(Calendar.DATE, -1);
//        remoteData.put("11", Arrays.asList("6"));
//        remoteData.put("12", Arrays.asList("7"));
//        remoteData.put("13", Arrays.asList("4"));
//        remoteData.put("14", Arrays.asList("3"));
//        remoteData.put("15", Arrays.asList("11"));
//        remoteData.put("16", Arrays.asList("11"));
//        remoteData.put("17", Arrays.asList("11"));
//        remoteData.put("18", Arrays.asList("11"));
//        remoteData.put("19", Arrays.asList("11"));
//        remoteData.put("20", Arrays.asList("11"));
//
//        Log.d("chartremotedata", remoteData.toString());
//
//        // Convert data to chart input
//        ArrayList<LineChartValue> lineChartData = ChartExtensionsKt.toOralHygieneChart(remoteData);
//        Log.d("chartremotedata", lineChartData.toString());
//        ArrayList<Triple<Drawable, String, Float>> convertedData = ChartExtensionsKt.convertToLinearChartData(lineChartData);
//        Log.d("chartremotedata", convertedData.toString());
//        // Setup tooltip and chart color
//        // In the triple data:
//        // first = Drawable
//        // second = date
//        // third = score
//        boolean isDataFake = false;
//        SliderTooltip sliderTooltip = new SliderTooltip();
//
//    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
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



    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }





}