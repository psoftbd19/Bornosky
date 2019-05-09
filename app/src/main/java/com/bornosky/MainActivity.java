package com.bornosky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnIndividualSMS).setOnClickListener(this);
        findViewById(R.id.btnAbsentSMS).setOnClickListener(this);
        findViewById(R.id.btnSMSForAllStudents).setOnClickListener(this);
        findViewById(R.id.btnTeachersSMS).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        int id = v.getId();
        switch (id) {
            case R.id.btnIndividualSMS:
                startActivity(new Intent(this, IndividualSMSActivity.class));
                break;
            case R.id.btnAbsentSMS:
                Toast.makeText(this, "Absent sms", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSMSForAllStudents:
                Toast.makeText(this, "SMS for all sms", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTeachersSMS:
                Toast.makeText(this, "Teachers sms", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
