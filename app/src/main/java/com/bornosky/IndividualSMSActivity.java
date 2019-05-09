package com.bornosky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class IndividualSMSActivity extends AppCompatActivity {


    private Spinner spinnerSession, spinnerBranch, spinnerClass, spinnerShift, spinnerSection, spinnerMessageType;

    String[] sessionArray = {"Select session","2018", "2019", "2020"};
    String[] branchArray = {"Select Branch","Main", "Bashabo", "Mugda"};
    String[] classArray = {"Select class","One","Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] shiftArray = {"Select shift","Morning","Day"};
    String[] sectionArray = {"Select section","A","B","C"};
    String[] messageTypeArray = {"Select message type","Bangla", "English"};
    String[] studentsArray = {"Nahid", "Nyon", "Moin", "Rashed","Ilias","Sogir","Mustafiz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_sms);

        spinnerSession = (Spinner) findViewById(R.id.spinnerSession);
        spinnerBranch = (Spinner) findViewById(R.id.spinnerBranch);
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);
        spinnerShift = (Spinner) findViewById(R.id.spinnerShift);
        spinnerSection = (Spinner) findViewById(R.id.spinnerSection);
        spinnerMessageType = (Spinner) findViewById(R.id.spinnerMessageType);

        ArrayAdapter<String> sessionAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, sessionArray);
        spinnerSession.setAdapter(sessionAdapter);
        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, branchArray);
        spinnerBranch.setAdapter(branchAdapter);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, classArray);
        spinnerClass.setAdapter(classAdapter);
        ArrayAdapter<String> shiftAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, shiftArray);
        spinnerShift.setAdapter(shiftAdapter);
        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, sectionArray);
        spinnerSection.setAdapter(sectionAdapter);

        ArrayAdapter<String> messageTypeAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, messageTypeArray);
        spinnerMessageType.setAdapter(messageTypeAdapter);

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, studentsArray);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(studentAdapter);




    }
}
