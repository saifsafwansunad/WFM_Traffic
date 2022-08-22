package com.example.wfm_traffic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.wfm_traffic.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddFinesActivity extends AppCompatActivity {

    Spinner spinnerSex,spinnerCity,spinnerState,spinnerVehicleType,spinnerVehicleColour,spinnerRegState;
    Spinner spinnerLicenseType,spinnerfinecaegory,spinnerPaymenttype;


    String[] sex = {"Male","Female"};

    String[] city = {"Alice", "Butterworth",
            "king Willian Town", "Port Elizabeth",
            "Bethlehem", "Cape Town"};

    String[] state = {"East Cape", "Free State",
            "Gauteg", "Limpopo"};

    String[] vehicletype = {"Hatchback","Sedan","MPV","SUV","Crossover","coup"};

    String[] vehiclecolour = {"Red", "Blue", "Green", "Gray", "Black", "White", "Yellow", "Purple", "Gold", "Aqua"};

    String[] regstate = {"East Cape", "Free State",
            "Gauteg", "Limpopo"};

    String[] licensetype ={"LMV", "HMV", "HPMV", "HGMV"};

    String[] finecategory = {"Arrests", "Discontinue Notice", "D/License", "Roadworthy Disc", "defect on Vehicle", "Lamps", "Over Speeding"};

    String[] paymentype = {"Cash", "Card",
            "Others"};
    int hour, minute;
    final Calendar myCalendar= Calendar.getInstance();
    TextView textViewDate,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fines);
        spinnerSex=findViewById(R.id.sex_spinner);
        spinnerCity=findViewById(R.id.city_spinner);
        spinnerState=findViewById(R.id.state_spinner);
        spinnerVehicleType=findViewById(R.id.Vehicletype_spinner);
        spinnerVehicleColour=findViewById(R.id.vehicle_colour_spinner);
        spinnerRegState=findViewById(R.id.regstate_spinner);
        spinnerLicenseType=findViewById(R.id.license_type_spinner);
        spinnerfinecaegory=findViewById(R.id.fine_caegory_spinner);
        spinnerPaymenttype=findViewById(R.id.payment_type_spinner);
        RelativeLayout relativeLayoutDate=findViewById(R.id.date_layout);
        title=findViewById(R.id.title);
        title.setText("Add Task");
        textViewDate=findViewById(R.id.date_textview);
        ImageView imageViewNotification=findViewById(R.id.notification);
//        imageViewNotification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),MessagesActivity.class);
//                startActivity(intent);
//            }
//        });

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }

        };
        relativeLayoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddFinesActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                sex);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinnerSex.setAdapter(ad);
        spinnerSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                state);

        // set simple layout resource file
        // for each item of spinner
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerState.setAdapter(ad2);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad4
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                vehicletype);

        // set simple layout resource file
        // for each item of spinner
        ad4.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(ad4);
        spinnerVehicleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad5
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                vehiclecolour);

        // set simple layout resource file
        // for each item of spinner
        ad5.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerVehicleColour.setAdapter(ad5);
        spinnerVehicleColour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter ad6
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                vehicletype);

        // set simple layout resource file
        // for each item of spinner
        ad6.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerRegState.setAdapter(ad6);
        spinnerRegState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad7
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                regstate);

        // set simple layout resource file
        // for each item of spinner
        ad7.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerRegState.setAdapter(ad7);
        spinnerRegState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter ad8
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                licensetype);

        // set simple layout resource file
        // for each item of spinner
        ad8.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerLicenseType.setAdapter(ad8);
        spinnerLicenseType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad9
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                finecategory);

        // set simple layout resource file
        // for each item of spinner
        ad9.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerfinecaegory.setAdapter(ad9);
        spinnerfinecaegory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad10
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                paymentype);

        // set simple layout resource file
        // for each item of spinner
        ad10.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerPaymenttype.setAdapter(ad10);
        spinnerPaymenttype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad11
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                city);

        // set simple layout resource file
        // for each item of spinner
        ad11.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerCity.setAdapter(ad11);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
//                textViewFromTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
//                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}