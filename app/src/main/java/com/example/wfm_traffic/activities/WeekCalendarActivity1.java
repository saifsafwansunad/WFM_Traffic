package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.week2.DateTimeInterpreter;
import com.example.wfm_traffic.week2.MonthLoader;
import com.example.wfm_traffic.week2.WeekView;
import com.example.wfm_traffic.week2.WeekViewEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import tarek360.animated.icons.AnimatedIconView;
import tarek360.animated.icons.IconFactory;

public class WeekCalendarActivity1 extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener, WeekView.EmptyViewLongPressListener {

    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;
    private WeekView mWeekView;
    ImageView dots,backarrow;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_calendar1);
        title=findViewById(R.id.title);
        title.setText("Events");

        backarrow=findViewById(R.id.imgBackArrow);

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

        dots=findViewById(R.id.dots_report1);

            dots.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            PopupMenu popupMenu = new PopupMenu(getApplicationContext(), dots);

//                MenuPopupHelper menuHelper = new MenuPopupHelper(UserMessages.this, (MenuBuilder) popupMenu.getMenu(), dots);
//                menuHelper.setForceShowIcon(true);
//                menuHelper.show();

                            /*  The below code in try catch is responsible to display icons*/
                            try {
                                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                                    for (Field field : fields) {
                                            if ("mPopup".equals(field.getName())) {
                                                    field.setAccessible(true);
                                                    Object menuPopupHelper = field.get(popupMenu);
                                                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                                                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                                                    setForceIcons.invoke(menuPopupHelper, true);
                                                    break;
                                            }
                                    }
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }

                            // Inflating popup menu from popup_menu.xml file
                            popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                            // Toast message on menu item clicked
                                            switch (menuItem.getItemId())
                                            {


                                                    case R.id.action_today:
                                                            mWeekView.goToToday();
                                                            return true;
                                                    case R.id.action_day_view:
                                                            if (mWeekViewType != TYPE_DAY_VIEW) {
                                                                    menuItem.setChecked(!menuItem.isChecked());
                                                                    setupDateTimeInterpreter(false);
                                                                    mWeekViewType = TYPE_DAY_VIEW;
                                                                    mWeekView.setNumberOfVisibleDays(1);

                                                                    // Lets change some dimensions to best fit the view.
                                                                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                                                                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                                                                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                                                            }
                                                            return true;
                                                    case R.id.action_three_day_view:
                                                            if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
                                                                    setupDateTimeInterpreter(false);
                                                                    menuItem.setChecked(!menuItem.isChecked());
                                                                    mWeekViewType = TYPE_THREE_DAY_VIEW;
                                                                    mWeekView.setNumberOfVisibleDays(3);

                                                                    // Lets change some dimensions to best fit the view.
                                                                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                                                                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                                                                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                                                            }
                                                            return true;
                                                    case R.id.action_week_view:
                                                            if (mWeekViewType != TYPE_WEEK_VIEW) {
                                                                    setupDateTimeInterpreter(true);
                                                                    menuItem.setChecked(!menuItem.isChecked());
                                                                    mWeekViewType = TYPE_WEEK_VIEW;
                                                                    mWeekView.setNumberOfVisibleDays(7);

                                                                    // Lets change some dimensions to best fit the view.
                                                                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                                                                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                                                                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                                                            }
                                                            return true;
                                            }


                                            return true;
                                    }
                            });
                            // Showing the popup menu
                            popupMenu.show();
                    }
            });
    }


/**
 * Set up a date time interpreter which will show short date values when in week view and long
 * date values otherwise.
 * @param shortDate True if the date values should be short.
 */
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
}