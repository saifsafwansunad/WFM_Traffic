package com.example.wfm_traffic.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wfm_traffic.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pub.devrel.easypermissions.EasyPermissions;
import tarek360.animated.icons.AnimatedIconView;
import tarek360.animated.icons.IconFactory;

public class RequestLeaveActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
TextView title;
ImageView imageViewUpload;
public static final int PICKFILE_RESULT_CODE = 1;
    private Uri fileUri;
    private String filePath;
    ActivityResultLauncher<Intent> resultLauncher;
    EditText editTextUpoad;
    RelativeLayout relativeLayoutFromDate,relativeLayouTodate;
    final Calendar myCalendar= Calendar.getInstance();

    Spinner spinnerLeaveCaegory;
    String[] leavecategory = {"Casual Leave(L)","Family Responsibility","Annual Leave(AL)","Sick Leave(SL)","Maternity Leave(ML)","Paternity Leave(PL)","Special Leave","Compensatory Off","Loss of Pay","Bearevement Leave","Privilege Leave"};
    TextView textViewFromDate,textViewToDate,textViewToTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_leave);
        title=findViewById(R.id.title);
        title.setText("Request Leave");

        imageViewUpload=findViewById(R.id.upload_imgview);
        editTextUpoad=findViewById(R.id.upload_edittext);
        relativeLayoutFromDate=findViewById(R.id.fromdate_layout);
        relativeLayouTodate=findViewById(R.id.to_date_layout);
        textViewToDate=findViewById(R.id.to_date_textview);
        textViewFromDate=findViewById(R.id.fromdate_textview);
        spinnerLeaveCaegory=findViewById(R.id.leave_category_spinner);
        ImageView backarrow=findViewById(R.id.imgBackArrow);

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

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                leavecategory);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinnerLeaveCaegory.setAdapter(ad);
        spinnerLeaveCaegory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        Button buttonsubmit=findViewById(R.id.submit_btn);
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RequestLeaveActivity.this, "Request Submited", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabelFromDate();
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

        relativeLayoutFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RequestLeaveActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        relativeLayouTodate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RequestLeaveActivity.this,dateTo,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        resultLauncher = registerForActivityResult(
                new ActivityResultContracts
                        .StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(
                            ActivityResult result)
                    {
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
                        RequestLeaveActivity.this,
                        Manifest.permission
                                .READ_EXTERNAL_STORAGE)
                        != PackageManager
                        .PERMISSION_GRANTED) {
                    // When permission is not granted
                    // Result permission
                    ActivityCompat.requestPermissions(
                            RequestLeaveActivity.this,
                            new String[] {
                                    Manifest.permission
                                            .READ_EXTERNAL_STORAGE },
                            1);
                }
                else {
                    // When permission is granted
                    // Create method
                    selectPDF();
                }
            }
        });
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

    private void updateLabelFromDate(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewFromDate.setText(dateFormat.format(myCalendar.getTime()));
    }
    private void updateLabelToDate(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        textViewToDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}