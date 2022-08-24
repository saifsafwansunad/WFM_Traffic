package com.example.wfm_traffic.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.wfm_traffic.R;
import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pub.devrel.easypermissions.EasyPermissions;

import static com.example.wfm_traffic.activities.RequestLeaveActivity.PICKFILE_RESULT_CODE;

public class AddTaskActivity extends AppCompatActivity  implements EasyPermissions.PermissionCallbacks {


    public static final int PICKFILE_RESULT_CODE = 1;
    ActivityResultLauncher<Intent> resultLauncher;
    private Uri fileUri;
    private String filePath;

    String[] taskcategory = {"Task Category 1", "Task Category 2",
            "Task Category 3", "Task Category 4",
            "Task Category 5", "Task Category 6"};

    String[] asignedto = {"Self", "Staff Memeber 1",
            "Staff Memeber 3", "Staff Memeber 4",
            "Staff Memeber 5"};

    String[] status = {"Not Started", "In Progress",
            "Completed","Deferred To","waiting on Someone else"};

    String[] priority =  {"1-High", "2-Normal",
            "3-Low"};

    final Calendar myCalendar= Calendar.getInstance();
    TextView textViewDate,textViewFromTime,textViewToTime;
    int hour, minute;
    EditText editTextUpoad;
    ImageView imageViewUpload;
//    RelativeLayout relativeLayoutFromDate,relativeLayouTodate;
    RelativeLayout relativeLayoutDate;

    TextView textViewFromDate,textViewToDate;


    RelativeLayout relativeLayoutFromTime;
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Spinner spin = findViewById(R.id.taskcategory_spinner);
        Spinner spinnerAssgine = findViewById(R.id.assigned_to_spinner);
        Spinner spinnerstatus = findViewById(R.id.status_spinner);
        Spinner spinnerpriority = findViewById(R.id.priority_spinner);
        relativeLayoutDate=findViewById(R.id.date_layout);
//        relativeLayouTodate=findViewById(R.id.to_date_layout);
//        textViewToDate=findViewById(R.id.date_textview);
//        textViewFromDate=findViewById(R.id.fromdate_textview);
MaterialButton materialButtonSubmit=findViewById(R.id.submit_btn);
materialButtonSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
        Toast.makeText(AddTaskActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
    }
});
        imageViewUpload = findViewById(R.id.upload_imgview);
        editTextUpoad = findViewById(R.id.upload_edittext);

        textViewFromTime = findViewById(R.id.from_time_textview);
        textViewToTime = findViewById(R.id.to_time_textview);
        title = findViewById(R.id.title);
        title.setText("Add Task");
        textViewDate = findViewById(R.id.date_textview);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }

        };
        DatePickerDialog.OnDateSetListener dateTo =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabelToDate();
            }

        };
        ImageView imageViewNotification=findViewById(R.id.notification);
        imageViewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MessagesActivity.class);
                startActivity(intent);
            }
        });

        imageViewNotification.startAnimation(AnimationUtils.loadAnimation(this,R.anim.shake));
        ImageView backarrow=findViewById(R.id.imgBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        relativeLayoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddTaskActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
//
//        relativeLayouTodate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(AddTaskActivity.this,dateTo,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//
//            }
//        });

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                taskcategory);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                asignedto);

        // set simple layout resource file
        // for each item of spinner
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        ArrayAdapter ad3
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                status);

        // set simple layout resource file
        // for each item of spinner
        ad3.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        ArrayAdapter ad4
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                priority);

        // set simple layout resource file
        // for each item of spinner
        ad4.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),
//                courses[i],
//                Toast.LENGTH_LONG)
//                .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerAssgine.setAdapter(ad2);
        spinnerAssgine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerstatus.setAdapter(ad3);
        spinnerstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerpriority.setAdapter(ad4);
        spinnerpriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts
                        .StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(
                            ActivityResult result) {
                        // Initialize result data
                        Intent data = result.getData();
                        // check condition
                        if (data != null) {
                            // When data is not equal to empty
                            // Get PDf uri
                            Uri sUri = data.getData();
                            // set Uri on text view
//                            tvUri.setText(Html.fromHtml(
//                                    "<big><b>PDF Uri</b></big><br>"
//                                            + sUri));

                            // Get PDF path
                            String sPath = sUri.getPath();
                            // Set path on text view
                            editTextUpoad.setHint(Html.fromHtml(
                                    "<b>File Path</b><br>"
                                            + sPath));
                        }
                    }
                });

        imageViewUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(
                        AddTaskActivity.this,
                        Manifest.permission
                                .READ_EXTERNAL_STORAGE)
                        != PackageManager
                        .PERMISSION_GRANTED) {
                    // When permission is not granted
                    // Result permission
                    ActivityCompat.requestPermissions(
                            AddTaskActivity.this,
                            new String[]{
                                    Manifest.permission
                                            .READ_EXTERNAL_STORAGE},
                            1);
                } else {
                    // When permission is granted
                    // Create method
                    selectPDF();
                }
            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method


//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//        Toast.makeText(getApplicationContext(),
//                courses[position],
//                Toast.LENGTH_LONG)
//                .show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                textViewFromTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
//                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    public void popTimePickerTo(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
//                textViewFromTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
                textViewToTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        // int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  R.style.MaterialCalendarTheme,/*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == -1) {
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
//                    tvItemPath.setText(filePath);
                }

                break;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        selectPDF();


    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast
                .makeText(getApplicationContext(),
                        "Permission Denied",
                        Toast.LENGTH_SHORT)
                .show();
    }

    private void selectPDF()
    {
        // Initialize intent
        Intent intent
                = new Intent(Intent.ACTION_GET_CONTENT);
        // set type
        intent.setType("*/*");
        // Launch intent
        resultLauncher.launch(intent);
    }


//    private void updateLabelFromDate(){
//        String myFormat="MM/dd/yy";
//        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
//        textViewFromDate.setText(dateFormat.format(myCalendar.getTime()));
//    }
    private void updateLabelToDate(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewDate.setText(dateFormat.format(myCalendar.getTime()));
    }

}
