package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.CalendarViewpagerAdap;
import com.example.wfm_traffic.model.CalenderObj;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    List<CalenderObj> daysListEvent = new ArrayList<>();
    List<CalenderObj> daysListEventAll = new ArrayList<>();
    String[] years = { "2020", "2021","2022","2023","2024","2025"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Spinner yearSpinner, monthSpinner;
    GridView gridview;
    CalendarAdapter ca;
    RelativeLayout monthCalendar,weekCalendar;
    AppCompatButton  Button,button1,button2,button3;
    View view4,view1,view2,view3;

    TabLayout tabLayoutMeetings;
    private ViewPager mViewPager,viewPagerMeeting;

    int presentTxt=0,absentTxt=0,holidaysTxt=0,totalDays=0;
    float attendancePercentage,absentPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_task);


        daysListEventAll.add(new CalenderObj(1, "2020", "October", "f"));
        daysListEventAll.add(new CalenderObj(2, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(3, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(4, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(5, "2020", "October", "a"));
        daysListEventAll.add(new CalenderObj(6, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(7, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(8, "2020", "October", "l"));
        daysListEventAll.add(new CalenderObj(9, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(10, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(11, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(12, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(13, "2020", "October", "a"));
        daysListEventAll.add(new CalenderObj(14, "2020", "October", "l"));
        daysListEventAll.add(new CalenderObj(15, "2020", "October", "l"));
        daysListEventAll.add(new CalenderObj(16, "2020", "October", "a"));
        daysListEventAll.add(new CalenderObj(17, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(18, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(19, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(20, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(21, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(22, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(23, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(24, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(25, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(26, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(27, "2020", "October", "f"));
        daysListEventAll.add(new CalenderObj(28, "2020", "October", "p"));
        daysListEventAll.add(new CalenderObj(29, "2020", "October", "h"));
        daysListEventAll.add(new CalenderObj(30, "2020", "October", "f"));
        daysListEventAll.add(new CalenderObj(31, "2020", "October", "p"));

        daysListEventAll.add(new CalenderObj(1, "2020", "November", "f"));
        daysListEventAll.add(new CalenderObj(2, "2020", "November", "h"));
        daysListEventAll.add(new CalenderObj(3, "2020", "November", "p"));
        daysListEventAll.add(new CalenderObj(4, "2020", "November", "o"));
        daysListEventAll.add(new CalenderObj(5, "2020", "November", "a"));
        daysListEventAll.add(new CalenderObj(6, "2020", "November", "p"));
        daysListEventAll.add(new CalenderObj(7, "2020", "November", "p"));
        daysListEventAll.add(new CalenderObj(8, "2020", "November", "p"));
        daysListEventAll.add(new CalenderObj(9, "2020", "November", "f"));
        daysListEventAll.add(new CalenderObj(10, "2020", "November", "l"));
        daysListEventAll.add(new CalenderObj(11, "2020", "November", "p"));
        daysListEventAll.add(new CalenderObj(12, "2020", "November", "o"));
        daysListEventAll.add(new CalenderObj(13, "2020", "November", "p"));


        for (int i=0;i<daysListEventAll.size();i++) {
            if (daysListEventAll.get(i).getEventType().equals("p")) {
                presentTxt++;
                totalDays++;
            } else if (daysListEventAll.get(i).getEventType().equals("a")) {
                absentTxt++;
                totalDays++;
            } else if (daysListEventAll.get(i).getEventType().equals("h")) {
                holidaysTxt++;
            }
        }

        attendancePercentage=(Float.parseFloat(presentTxt+"")*100)/Float.parseFloat(totalDays+"");
        absentPercentage=100-attendancePercentage;



        double present = Double.parseDouble(new DecimalFormat("00.00").format(attendancePercentage));
        double absent=Double.parseDouble(new DecimalFormat("00.00").format(absentPercentage));

//        List<SliceValue> attendance = new ArrayList();
//
//        attendance.add(new SliceValue(presentTxt, Color.parseColor("#0C9C07")).setLabel(present+"%"));
//        attendance.add(new SliceValue(absentTxt, Color.parseColor("#9C0722")).setLabel(absent+"%"));

//bro, this is for getting current month and year, to open directly when we open app
        Calendar calander = Calendar.getInstance();
        int cMonth = calander.get(Calendar.MONTH) ;
        int cYear = calander.get(Calendar.YEAR);

        //cDay = calander.get(Calendar.DAY_OF_MONTH);
        //selectedMonth = "" + cMonth;
        //selectedYear = "" + cYear;
        //cHour = calander.get(Calendar.HOUR);
        //cMinute = calander.get(Calendar.MINUTE);
        // cSecond = calander.get(Calendar.SECOND);

        yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_text, years);
        yearSpinner.setAdapter(adapter);
        yearSpinner.setSelection(0);
        yearSpinner.setOnItemSelectedListener(this);



        monthSpinner = findViewById(R.id.month_spinner);
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_text, months);
        monthSpinner.setAdapter(adapter1);
        monthSpinner.setSelection(cMonth);
        monthSpinner.setOnItemSelectedListener(this);


        gridview = findViewById(R.id.gridview);
        ca = new CalendarAdapter(CalendarTaskActivity.this);
        gridview.setAdapter(ca);


        createCalendar(2018, Calendar.JUNE);

//        viewPagerMeeting=findViewById(R.id.calendar_viewPager);
//        tabLayoutMeetings=findViewById(R.id.calendar_tablayout);
//
//        tabLayoutMeetings.addTab(tabLayoutMeetings.newTab().setText("Month"));
//
//        tabLayoutMeetings.addTab(tabLayoutMeetings.newTab().setText("Week"));
//        tabLayoutMeetings.addTab(tabLayoutMeetings.newTab().setText("Day"));
//        tabLayoutMeetings.addTab(tabLayoutMeetings.newTab().setText("List"));
//
//        tabLayoutMeetings.setTabGravity(TabLayout.GRAVITY_FILL);
//        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
//        Log.d("hello", tabLayoutMeetings.getTabCount()+"s");
//
//        final CalendarViewpagerAdap messagesAdapter = new CalendarViewpagerAdap(this, getSupportFragmentManager(), tabLayoutMeetings.getTabCount());
//        viewPagerMeeting.setAdapter(messagesAdapter);
//
//        viewPagerMeeting.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMeetings));
//
//
//        tabLayoutMeetings.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPagerMeeting.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        monthCalendar = findViewById(R.id.month_calendar);
        weekCalendar = findViewById(R.id.week_calendar);

//        monthCalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MonthCalendarActivity1.class);
//                startActivity(intent);
//            }
//        });

        weekCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeekCalendarActivity1.class);
                startActivity(intent);
            }
        });

        Button = findViewById(R.id.rect);
        view4 = findViewById(R.id.view2);
        button1 = findViewById(R.id.rect1);
        view1 = findViewById(R.id.view1);
        button2 = findViewById(R.id.rect2);
        view2 = findViewById(R.id.view3);
        button3 = findViewById(R.id.rect3);
        view3 = findViewById(R.id.view4);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                Button.setBackground(getDrawable(R.drawable.rect1));
                Button.setTextColor(Color.parseColor("#FFFFFF"));
                view4.setVisibility(View.VISIBLE);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button1.setBackground(getDrawable(R.drawable.rect1));
                button1.setTextColor(Color.parseColor("#FFFFFF"));
                view1.setVisibility(View.VISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button2.setBackground(getDrawable(R.drawable.rect1));
                button2.setTextColor(Color.parseColor("#FFFFFF"));
                view2.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button3.setBackground(getDrawable(R.drawable.rect1));
                button3.setTextColor(Color.parseColor("#FFFFFF"));
                view3.setVisibility(View.VISIBLE);
            }
        });

    }

    public void  intButton(){
        Button.setBackground(getDrawable(R.drawable.rect));
        button1.setBackground(getDrawable(R.drawable.rect));
        button2.setBackground(getDrawable(R.drawable.rect));
        button3.setBackground(getDrawable(R.drawable.rect));
        Button.setTextColor(Color.parseColor("#7A5299"));
        button1.setTextColor(Color.parseColor("#7A5299"));
        button2.setTextColor(Color.parseColor("#7A5299"));
        button3.setTextColor(Color.parseColor("#7A5299"));
        view4.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
    }

    private void createCalendar(int year, int month) {
        int day = 1;
        for (int i = 0; i < texts.length; i++)
            texts[i] = "";
        GregorianCalendar cal = new GregorianCalendar(year, month, day);
        int nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        for (int j = 0; j < days.length; j++)
            texts[j] = days[j];
        for (int i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            texts[((row + 1) * 7) + column] = String.valueOf(i);

        }
        ca.notifyDataSetChanged();
    }


    private String[] texts = new String[49];

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        daysListEvent.clear();
        for (int k=0;k<daysListEventAll.size();k++) {
            if (daysListEventAll.get(k).getYear().equals(yearSpinner.getSelectedItem().toString())) {
                if (daysListEventAll.get(k).getMonth().equals(monthSpinner.getSelectedItem().toString())) {
                    daysListEvent.add(new CalenderObj(daysListEventAll.get(k).getDay(), daysListEventAll.get(k).getYear(), daysListEventAll.get(k).getMonth(), daysListEventAll.get(k).getEventType()));
                }
            }
        }
        createCalendar(Integer.parseInt((String) yearSpinner.getSelectedItem()), monthSpinner.getSelectedItemPosition());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class CalendarAdapter extends BaseAdapter {
        Button btn;
        private Context mContext;


        public CalendarAdapter(Context c) {
            mContext = c;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }


        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
                btn = new Button(mContext);

                btn.setLayoutParams(new GridView.LayoutParams(display.getWidth() / 7, ViewGroup.LayoutParams.WRAP_CONTENT));

            } else {
                btn = (Button) convertView;
            }
            if (texts[position].equals("")) {

                btn.setVisibility(View.GONE);
                btn.setFocusable(false);
                btn.setClickable(false);
            } else {
                btn.setVisibility(View.VISIBLE);
                btn.setFocusable(true);
            }
            btn.setText(texts[position]);

//                for (int i = 0; i < daysListEvent.size(); i++) {
//                    if (position == daysListEvent.get(i).getDay() && month.equals(daysListEvent.get(i).getMonth()) && yearSpinner.getSelectedItem().equals(daysListEvent.get(i).getYear())) {
//                        btn.setBackgroundColor(Color.parseColor("#33F9FF"));
//                    }else {
//                        btn.setBackgroundColor(Color.parseColor("#3355FF"));
//                    }
//                }

            btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            for (int i = 0; i < daysListEvent.size(); i++) {
//                if (yearSpinner.getSelectedItem().equals(daysListEvent.get(i).getYear())) {
//                    if (monthSpinner.getSelectedItem().toString().equals(daysListEvent.get(i).getMonth())) {
//                        if (texts[position].equals(daysListEvent.get(i).getDay()+"")) {
//                            if (daysListEvent.get(i).getEventType().equals("p")) {
//                                btn.setBackgroundResource(R.drawable.circlegreen);
//                                //btn.setBackgroundColor(Color.parseColor("#0C9C07"));
//                            } else if (daysListEvent.get(i).getEventType().equals("a")) {
//                                btn.setBackgroundResource(R.drawable.circlered);
//                                //btn.setBackgroundColor(Color.parseColor("#9C0722"));
//                            } else if (daysListEvent.get(i).getEventType().equals("h")) {
//                                btn.setBackgroundResource(R.drawable.circlepurple);
//                                //btn.setBackgroundColor(Color.parseColor("#9C0791"));
//                            }else if (daysListEvent.get(i).getEventType().equals("f")) {
//                                btn.setBackgroundResource(R.drawable.circlepink);
//                                // btn.setBackgroundColor(Color.parseColor("#7f170c"));
//                            }else if (daysListEvent.get(i).getEventType().equals("l")) {
//                                btn.setBackgroundResource(R.drawable.circleblue);
//                                //btn.setBackgroundColor(Color.parseColor("#07f2f2"));
//                            }else if (daysListEvent.get(i).getEventType().equals("o")) {
//                                btn.setBackgroundResource(R.drawable.circlegrey);
//                                //btn.setBackgroundColor(Color.parseColor("#07f2f2"));
//                            }
//                        }
//                    } else {
//                        btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                    }
//                } else {
//                    btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                }
//            }

            if (position == 7 || position == 14 || position == 21 || position == 28 || position == 35 || position == 42) {
                //btn.setBackgroundColor(Color.parseColor("#07A796"));
            }
            if (position == 0 || position==1 || position == 2 || position == 3 || position == 4|| position == 5 || position == 6 ) {
                btn.setBackgroundColor(Color.parseColor("#D6EAF8"));
            }
            return btn;
        }

        @Override
        public int getCount() {
            return texts.length;
        }

    }
}