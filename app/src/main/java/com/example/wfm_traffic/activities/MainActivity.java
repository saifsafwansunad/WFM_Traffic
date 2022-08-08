package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Area;
import com.anychart.core.ui.Crosshair;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.Stroke;
import com.example.wfm_traffic.R;
import com.example.wfm_traffic.ShadowTransformer;
import com.example.wfm_traffic.adapter.CardFragmentPagerAdapter;
import com.example.wfm_traffic.adapter.CardPagerAdapter;
import com.example.wfm_traffic.adapter.ExpandableListAdapter;
import com.example.wfm_traffic.adapter.helperclasses.adapteCard;
import com.example.wfm_traffic.adapter.helperclasses.cardmodel;
import com.example.wfm_traffic.chart.tooltip.SliderTooltip;

import com.example.wfm_traffic.databinding.ActivityMainBinding;
import com.example.wfm_traffic.databinding.HomePageBinding;
import com.example.wfm_traffic.model.MenuModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements adapteCard.ListItemClickListener {

    ImageView drawer_left;
    private DrawerLayout drawer;
    TabLayout tabLayoutMessages;
    ViewPager viewPagerMessages;
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
    private LineChart volumeReportChart;

    RecyclerView recyclerViewCard;
    RecyclerView.Adapter adapter;

    String[] strAr = {"Submitted", "Verified", "Approved","Rejected","IA Approved","IA Rejected"};
    int[] intvalues={501,300,204,165,128,117};
    AnyChartView anyChartViewPieChart,areaChart1;

//    private ViewPager mViewPager;
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
//        sliderTooltip = new SliderTooltip();
//        ActivityFunc fun = new ActivityFunc();
//        fun.setupLinearChart(new SliderTooltip(),binding,getApplicationContext());
//        fun.setupLinearChart1(new SliderTooltip(),binding,getApplicationContext());
//        fun.setupLinearChart2(new SliderTooltip(),binding,getApplicationContext());
//        fun.setupLinearChart3(new SliderTooltip(),binding,getApplicationContext());
        anyChartViewPieChart=(AnyChartView)findViewById(R.id.piechart);
//        areaChart1=(AnyChartView)findViewById(R.id.any_chart_view);
        setupChartView();
//        setupAreaChart();
        //        setupLinearChart();
        //        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        recyclerViewCard=(RecyclerView)findViewById(R.id.card_recycler);
        setuptCardRecyclerview();
//        mCardAdapter = new CardPagerAdapter();
//        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1,R.mipmap.clipboard));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1,R.mipmap.approve_tasks));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1,R.mipmap.calendar));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1,R.mipmap.fine));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_5, R.string.text_1,R.mipmap.overtime));
//
//        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
//                dpToPixels(2, this));

//        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
//        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
//
//        mViewPager.setAdapter(mCardAdapter);
//        mViewPager.setPageTransformer(false, mCardShadowTransformer);
//        mViewPager.setOffscreenPageLimit(3);

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

        volumeReportChart = findViewById(R.id.reportingChart);
        volumeReportChart.setTouchEnabled(true);
        volumeReportChart.setPinchZoom(true);
        List<String> dates = new ArrayList<>();
        dates.add("2022-04-14");
        dates.add("2022-04-21");
        dates.add("2022-04-28");
        dates.add("2022-04-25");
        List<Double> allAmounts = new ArrayList<>();
        allAmounts.add(42.1);
        allAmounts.add(59.3);
        allAmounts.add(68.7);
        allAmounts.add(82.4);
        renderData(dates,allAmounts);

        tabLayoutMessages = (TabLayout) findViewById(R.id.messages_tablayout);
        TextView fine_last_month  = findViewById(R.id.fine_last_month);
        TextView fine_yesterday  = findViewById(R.id.fine_yesterday);
        TextView fine_today  = findViewById(R.id.fine_today);
//        viewPagerMessages = (ViewPager) findViewById(R.id.messages_viewPager);

        tabLayoutMessages.addTab(tabLayoutMessages.newTab().setText("Arrests"));
        tabLayoutMessages.addTab(tabLayoutMessages.newTab().setText("Discontinue Notice"));
        tabLayoutMessages.addTab(tabLayoutMessages.newTab().setText("D/Licence"));

        tabLayoutMessages.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayoutMessages.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                viewPagerMessages.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                            fine_last_month.setText("R 7,561.00");
                            fine_yesterday.setText("R 7,561.00");
                            fine_today.setText("R 7,561.00");
                        List<String> dates = new ArrayList<>();
                        dates.add("2022-04-14");
                        dates.add("2022-04-21");
                        dates.add("2022-04-28");
                        dates.add("2022-04-25");
                        List<Double> allAmounts = new ArrayList<>();
                        allAmounts.add(42.1);
                        allAmounts.add(59.3);
                        allAmounts.add(68.7);
                        allAmounts.add(82.4);
                        renderData(dates,allAmounts);
                        volumeReportChart.notifyDataSetChanged();
                        volumeReportChart.invalidate();
                            break;

                    case 1:
                        fine_last_month.setText("R 60,908");
                        fine_yesterday.setText("R 07,908");
                        fine_today.setText("R 50,908");
                        List<String> dates1 = new ArrayList<>();
                        dates1.add("2022-04-14");
                        dates1.add("2022-04-21");
                        dates1.add("2022-04-28");
                        dates1.add("2022-04-25");
                        List<Double> allAmounts1 = new ArrayList<>();
                        allAmounts1.add(59.1);
                        allAmounts1.add(49.3);
                        allAmounts1.add(78.7);
                        allAmounts1.add(62.4);
                        renderData(dates1,allAmounts1);
                        volumeReportChart.notifyDataSetChanged();
                        volumeReportChart.invalidate();
                        break;

                    case 2:
                        fine_last_month.setText("R 990,908");
                        fine_yesterday.setText("R 97,908");
                        fine_today.setText("R 30,908");
                        List<String> dates2 = new ArrayList<>();
                        dates2.add("2022-04-14");
                        dates2.add("2022-04-21");
                        dates2.add("2022-04-28");
                        dates2.add("2022-04-25");
                        List<Double> allAmounts2 = new ArrayList<>();
                        allAmounts2.add(78.1);
                        allAmounts2.add(59.3);
                        allAmounts2.add(68.7);
                        allAmounts2.add(42.4);
                        renderData(dates2,allAmounts2);
                        volumeReportChart.notifyDataSetChanged();
                        volumeReportChart.invalidate();
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupAreaChart() {
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian areaChart = AnyChart.area();

        areaChart.animation(true);

        Crosshair crosshair = areaChart.crosshair();
        crosshair.enabled(true);
        // TODO yStroke xStroke in crosshair
        crosshair.yStroke((Stroke) null, null, null, (String) null, (String) null)
                .xStroke("#fff", 1d, null, (String) null, (String) null)
                .zIndex(39d);
        crosshair.yLabel(0).enabled(true);

        areaChart.yScale().stackMode(ScaleStackMode.VALUE);

        areaChart.title("Unaudited Apple Inc. Revenue by Operating Segments");

        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("Q2 2014", 17.982, 10.941, 9.835, 4.047, 2.841));
        seriesData.add(new CustomDataEntry("Q3 2014", 17.574, 8.659, 6.230, 2.627, 2.242));
        seriesData.add(new CustomDataEntry("Q4 2014", 19.75, 10.35, 6.292, 3.595, 2.136));
        seriesData.add(new CustomDataEntry("Q1 2015", 30.6, 17.2, 16.1, 5.4, 5.2));
        seriesData.add(new CustomDataEntry("Q2 2015", 21.316, 12.204, 16.823, 3.457, 4.210));
        seriesData.add(new CustomDataEntry("Q3 2015", 20.209, 10.342, 13.23, 2.872, 2.959));
        seriesData.add(new CustomDataEntry("Q4 2015", 21.773, 10.577, 12.518, 3.929, 2.704));
        seriesData.add(new CustomDataEntry("Q1 2016", 29.3, 17.9, 18.4, 4.8, 5.4));

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");
        Mapping series5Data = set.mapAs("{ x: 'x', value: 'value5' }");

        Area series1 = areaChart.area(series1Data);
        series1.name("Americas");
        series1.stroke("3 #fff");
        series1.hovered().stroke("3 #fff");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series1.markers().zIndex(100d);

//        Area series2 = areaChart.area(series2Data);
//        series2.name("Europe");
//        series2.stroke("3 #fff");
//        series2.hovered().stroke("3 #fff");
//        series2.hovered().markers().enabled(true);
//        series2.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series2.markers().zIndex(100d);
//
//        Area series3 = areaChart.area(series3Data);
//        series3.name("Greater China");
//        series3.stroke("3 #fff");
//        series3.hovered().stroke("3 #fff");
//        series3.hovered().markers().enabled(true);
//        series3.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series3.markers().zIndex(100d);
//
//        Area series4 = areaChart.area(series4Data);
//        series4.name("Japan");
//        series4.stroke("3 #fff");
//        series4.hovered().stroke("3 #fff");
//        series4.hovered().markers().enabled(true);
//        series4.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series4.markers().zIndex(100d);
//
//        Area series5 = areaChart.area(series5Data);
//        series5.name("Rest of Asia Pacific");
//        series5.stroke("3 #fff");
//        series5.hovered().stroke("3 #fff");
//        series5.hovered().markers().enabled(true);
//        series5.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series5.markers().zIndex(100d);

        areaChart.legend().enabled(true);
        areaChart.legend().fontSize(13d);
        areaChart.legend().padding(0d, 0d, 20d, 0d);

        areaChart.xAxis(0).title(false);
        areaChart.yAxis(0).title("Revenue (in Billons USD)");

        areaChart.interactivity().hoverMode(HoverMode.BY_X);
        areaChart.tooltip()
                .valuePrefix("$")
                .valuePostfix(" bln.")
                .displayMode(TooltipDisplayMode.UNION);

        anyChartView.setChart(areaChart);
    }

    private void setuptCardRecyclerview() {
        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        recyclerViewCard.setHasFixedSize(true);
        recyclerViewCard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<cardmodel> phonelocations = new ArrayList<>();
        phonelocations.add(new cardmodel(R.mipmap.approve_tasks,"Today's Tasks","14"));
        phonelocations.add(new cardmodel(R.mipmap.calendar,"Approve Tasks","16"));
        phonelocations.add(new cardmodel(R.mipmap.clipboard,"Approve Leave","24"));
        phonelocations.add(new cardmodel(R.mipmap.fine,"Fines","26"));
        phonelocations.add(new cardmodel(R.mipmap.overtime,"OverTime","18"));



        adapter = new adapteCard(phonelocations,this);
        recyclerViewCard.setAdapter(adapter);
    }

    public void renderData(List<String> dates, List<Double> allAmounts) {

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("1");
        xAxisLabel.add("7");
        xAxisLabel.add("14");
        xAxisLabel.add("21");
        xAxisLabel.add("28");
        xAxisLabel.add("30");

        XAxis xAxis = volumeReportChart.getXAxis();
        XAxis.XAxisPosition position = XAxis.XAxisPosition.BOTTOM;
        xAxis.setPosition(position);
        xAxis.enableGridDashedLine(2f, 7f, 0f);
        xAxis.setAxisMaximum(5f);
        xAxis.setAxisMinimum(0f);
        xAxis.setLabelCount(6, true);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(7f);
        xAxis.setLabelRotationAngle(315f);

        xAxis.setValueFormatter(new ClaimsXAxisValueFormatter(dates));

        xAxis.setCenterAxisLabels(true);


        xAxis.setDrawLimitLinesBehindData(true);



        LimitLine ll1 = new LimitLine(30f,"Title");
        ll1.setLineColor(getResources().getColor(R.color.gray400Dark));
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll1.setTextSize(10f);

        LimitLine ll2 = new LimitLine(35f, "");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);
        ll2.setLineColor(Color.parseColor("#FFFFFF"));

        xAxis.removeAllLimitLines();
        xAxis.addLimitLine(ll1);
        xAxis.addLimitLine(ll2);


        YAxis leftAxis = volumeReportChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        //leftAxis.addLimitLine(ll1);
        //leftAxis.addLimitLine(ll2);

        leftAxis.setAxisMaximum(findMaximumValueInList(allAmounts).floatValue() + 100f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(false);
        //XAxis xAxis = mBarChart.getXAxis();
        leftAxis.setValueFormatter(new ClaimsYAxisValueFormatter());

        volumeReportChart.getDescription().setEnabled(true);
        Description description = new Description();
        // description.setText(UISetters.getFullMonthName());//commented for weekly reporting
        description.setText("Week");
        description.setTextSize(15f);
        volumeReportChart.getDescription().setPosition(0f, 0f);
        volumeReportChart.setDescription(description);
        volumeReportChart.getAxisRight().setEnabled(false);

        //setData()-- allAmounts is data to display;
        setDataForWeeksWise(allAmounts);

    }

    private void setDataForWeeksWise(List<Double> amounts) {

        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(1, amounts.get(0).floatValue()));
        values.add(new Entry(2, amounts.get(1).floatValue()));
        values.add(new Entry(3, amounts.get(2).floatValue()));
        values.add(new Entry(4, amounts.get(3).floatValue()));


        LineDataSet set1;
        if (volumeReportChart.getData() != null &&
                volumeReportChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) volumeReportChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            volumeReportChart.getData().notifyDataChanged();
            volumeReportChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "Total volume");
            set1.setDrawCircles(true);
            set1.enableDashedLine(10f, 0f, 0f);
            set1.enableDashedHighlightLine(10f, 0f, 0f);
            set1.setColor(getResources().getColor(R.color.violet));
            set1.setCircleColor(getResources().getColor(R.color.violet));
            set1.setLineWidth(2f);//line size
            set1.setCircleRadius(5f);
            set1.setDrawCircleHole(true);
            set1.setValueTextSize(10f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(5f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(5.f);

            if (Utils.getSDKInt() >= 18) {
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.blue_bg);
//                set1.setFillDrawable(drawable);
                set1.setFillColor(Color.WHITE);

            } else {
                set1.setFillColor(Color.WHITE);
            }
            set1.setDrawValues(true);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);

            volumeReportChart.setData(data);
        }
    }

    private Number findMaximumValueInList(List<Double> list) {
        // check list is empty or not
        if (list == null || list.size() == 0) {
            return Integer.MIN_VALUE;
        }

        // return maximum value of the ArrayList
        return Collections.max(list);
    }

    private void setupChartView() {
Pie pie= AnyChart.pie();
       pie.legend(false);
       pie.background("#7A5299");


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

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {

                if (groupPosition == 1) {
                    if (childPosition == 0) {
                        Intent intent = new Intent(MainActivity.this, CalendarTaskActivity.class);
                        startActivity(intent);
                    }
                    else if (childPosition == 1) {
                        Intent intent = new Intent(MainActivity.this, AssignedTaskActivity.class);
                        startActivity(intent);
                    }else if (childPosition == 2) {
                        Intent intent = new Intent(MainActivity.this, ApproveTaskActivity.class);
                        startActivity(intent);
                    }
                    else if (childPosition == 3) {
                        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                        startActivity(intent);
                    } else if (childPosition == 4) {
                        Intent intent = new Intent(MainActivity.this, TimeSheetActivity.class);
                        startActivity(intent);
                    }
                }
                else if (groupPosition==2){
                    if (childPosition==1){
                        Intent intent = new Intent(MainActivity.this, AddFinesActivity.class);
                        startActivity(intent);
                    }
                    if (childPosition==0){
                        Intent intent = new Intent(MainActivity.this, FinesCalendarActivity.class);
                        startActivity(intent);
                    }
                    if (childPosition==2){
                        Intent intent = new Intent(MainActivity.this, FinesActivity.class);
                        startActivity(intent);
                    }
                }else if(groupPosition ==3){

                    if (childPosition==0){
                        Intent intent = new Intent(MainActivity.this, LeaveCalendarActivity.class);
                        startActivity(intent);
                    }
                    if (childPosition==3){
                        Intent intent = new Intent(MainActivity.this, ApproveLeaveActivity.class);
                        startActivity(intent);
                    }

                }else if (groupPosition == 4){
                    if (childPosition==0){
                        Intent intent = new Intent(MainActivity.this, OvertimeCalendarActivity.class);
                        startActivity(intent);
                    }
                    if (childPosition==2){
                        Intent intent = new Intent(MainActivity.this, OvertimeListActivity.class);
                        startActivity(intent);
                    }
                }


                return false;
            }
        });
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel(R.drawable.icons8_home_50,"Dashboard", true, false); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }
        menuModel = new MenuModel(R.drawable.icons8_task_50,"Task",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel(R.drawable.calendaer,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.assigned_task,"Assigned Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.approve_task,"Approve Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.overtime2,"Add Tasks", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.calendar,"Time Sheet", false, false);
        childModelsList.add(childModel);




        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel(R.drawable.icons8_banknotes_32,"Fines",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel(R.drawable.calendaer,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.icons8_banknotes_32,"Add Fines", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.clock,"Fines", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
        childModelsList = new ArrayList<>();
        menuModel = new MenuModel(R.drawable.icons8_leave_48,"Leaves",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel(R.drawable.calendaer,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.overtime,"Request Leave", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.assigned_task,"Leave Detail", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.approve_task,"Approve Leave", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
        childModelsList = new ArrayList<>();
        menuModel = new MenuModel(R.drawable.icons8_overtime_64,"Overtime",true, true); //Menu of Java Tutorials
        headerList.add(menuModel);

        childModel = new MenuModel(R.drawable.calendaer,"Calendar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.overtime,"Overtimes", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.overtime1,"Overtimes List", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel(R.drawable.overtime2,"Overtimes Approval", false, false);
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

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }


    public class ClaimsXAxisValueFormatter extends ValueFormatter {

        List<String> datesList;

        public ClaimsXAxisValueFormatter(List<String> arrayOfDates) {
            this.datesList = arrayOfDates;
        }


        @Override
        public String getAxisLabel(float value, AxisBase axis) {
/*
Depends on the position number on the X axis, we need to display the label, Here, this is the logic to convert the float value to integer so that I can get the value from array based on that integer and can convert it to the required value here, month and date as value. This is required for my data to show properly, you can customize according to your needs.
*/
            Integer position = Math.round(value);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");

            if (value > 1 && value < 2) {
                position = 0;
            } else if (value > 2 && value < 3) {
                position = 1;
            } else if (value > 3 && value < 4) {
                position = 2;
            } else if (value > 4 && value <= 5) {
                position = 3;
            }
            if (position < datesList.size())
                return sdf.format(new Date((getDateInMilliSeconds(datesList.get(position), "yyyy-MM-dd"))));
            return "";
        }
    }

    public static long getDateInMilliSeconds(String givenDateString, String format) {
        String DATE_TIME_FORMAT = format;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.US);
        long timeInMilliseconds = 1;
        try {
            Date mDate = sdf.parse(givenDateString);
            timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeInMilliseconds;
    }

    public class ClaimsYAxisValueFormatter extends ValueFormatter {

        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            return "R " +value;
        }
    }


    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }


}