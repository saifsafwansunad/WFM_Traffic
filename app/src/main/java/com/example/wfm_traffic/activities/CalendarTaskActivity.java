package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.adapter.CalendarViewpagerAdap;
import com.example.wfm_traffic.model.CalenderObj;
import com.example.wfm_traffic.week2.DateTimeInterpreter;
import com.example.wfm_traffic.week2.MonthLoader;
import com.example.wfm_traffic.week2.WeekView;
import com.example.wfm_traffic.week2.WeekViewEvent;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class CalendarTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener, WeekView.EmptyViewLongPressListener{

    List<CalenderObj> daysListEvent = new ArrayList<>();
    List<CalenderObj> daysListEventAll = new ArrayList<>();
    String[] years = { "2020", "2021","2022","2023","2024","2025"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Spinner yearSpinner, monthSpinner;
    GridView gridview;
    CalendarAdapter ca;
    RelativeLayout monthCalendar,weekCalendar;
    AppCompatButton  Button,button1,button2;
    LinearLayout calendar_spinneer;
    CardView cardView;
    View view4,view1,view2;
    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;
    private WeekView mWeekView;
    ImageView dots,backarrow;
    TextView title;

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
//        button3 = findViewById(R.id.rect3);
//        view3 = findViewById(R.id.view4);
        calendar_spinneer = findViewById(R.id.calender_spinner);
        cardView = findViewById(R.id.calendar_card);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                Button.setBackground(getDrawable(R.drawable.rect1));
                Button.setTextColor(Color.parseColor("#FFFFFF"));
                view4.setVisibility(View.VISIBLE);
                mWeekView.setVisibility(View.GONE);
                calendar_spinneer.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.VISIBLE);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button1.setBackground(getDrawable(R.drawable.rect1));
                button1.setTextColor(Color.parseColor("#FFFFFF"));
                view1.setVisibility(View.VISIBLE);
                mWeekView.setVisibility(View.VISIBLE);
                calendar_spinneer.setVisibility(View.GONE);
                cardView.setVisibility(View.GONE);
                if (mWeekViewType != TYPE_WEEK_VIEW) {
                    setupDateTimeInterpreter(true);
                    mWeekViewType = TYPE_WEEK_VIEW;
                    mWeekView.setNumberOfVisibleDays(7);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intButton();
                button2.setBackground(getDrawable(R.drawable.rect1));
                button2.setTextColor(Color.parseColor("#FFFFFF"));
                view2.setVisibility(View.VISIBLE);
                mWeekView.setVisibility(View.VISIBLE);
                calendar_spinneer.setVisibility(View.GONE);
                cardView.setVisibility(View.GONE);

                if (mWeekViewType != TYPE_DAY_VIEW) {
                    setupDateTimeInterpreter(false);
                    mWeekViewType = TYPE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(1);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
            }
        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intButton();
//                button3.setBackground(getDrawable(R.drawable.rect1));
//                button3.setTextColor(Color.parseColor("#FFFFFF"));
//                view3.setVisibility(View.VISIBLE);
//            }
//        });

        // Get a reference for the week view in the layout.
        mWeekView = (WeekView) findViewById(R.id.weekView);

        // Show a toast message about the touched event.
        mWeekView.setEventClickListener(this);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);

        // Set long press listener for empty view
        mWeekView.setEmptyViewLongPressListener(this);

        // Set up a date time interpreter to interpret how the date and time will be formatted in
        // the week view. This is optional.
        setupDateTimeInterpreter(false);

    }

    private void setupDateTimeInterpreter(final boolean shortDate) {
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String getFormattedWeekDayTitle(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("E", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                // All android api level do not have a standard way of getting the first letter of
                // the week day name. Hence we get the first char programmatically.
                // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
                if (shortDate)
                    weekday = String.valueOf(weekday.charAt(0));
                return weekday.toUpperCase() + format.format(date.getTime());
            }

            @Override
            public String getFormattedTimeOfDay(int hour, int miniute) {
                return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
            }
        });
    }

    protected String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH)+1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
        Toast.makeText(this, "Clicked " + event.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
        Toast.makeText(this, "Long pressed event: " + event.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyViewLongPress(Calendar time) {
        Toast.makeText(this, "Empty view long pressed: " + getEventTitle(time), Toast.LENGTH_SHORT).show();
    }

    public WeekView getWeekView() {
        return mWeekView;
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, newMonth-1);
        WeekViewEvent event = new WeekViewEvent("1", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.material_on_primary_emphasis_high_type));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent("10", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.secondary200));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 20);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 5);
        endTime.set(Calendar.MINUTE, 0);
        event = new WeekViewEvent("10", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.teal_700));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent("2", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.teal_200));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        startTime.add(Calendar.DATE, 1);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent("3", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.teal_700));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent("4", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.teal_200));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent("5", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.teal_700));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
        startTime.set(Calendar.HOUR_OF_DAY, 15);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent("5", getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.editTextEyeColor));
        events.add(event);

        return events;
    }

    public void  intButton(){
        Button.setBackground(getDrawable(R.drawable.rect));
        button1.setBackground(getDrawable(R.drawable.rect));
        button2.setBackground(getDrawable(R.drawable.rect));
//        button3.setBackground(getDrawable(R.drawable.rect));
        Button.setTextColor(Color.parseColor("#7A5299"));
        button1.setTextColor(Color.parseColor("#7A5299"));
        button2.setTextColor(Color.parseColor("#7A5299"));
//        button3.setTextColor(Color.parseColor("#7A5299"));
        view4.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
//        view3.setVisibility(View.INVISIBLE);
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