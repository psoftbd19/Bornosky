package com.bornosky.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bornosky.R;
import com.bornosky.adapter.DataItemAdapter;
import com.bornosky.model.StudentInfo;
import com.bornosky.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.List;

public class AbsentMessage extends AppCompatActivity {

    private Spinner spinnerSession, spinnerBranch, spinnerClass, spinnerShift, spinnerSection, spinnerMessageType;

    String[] sessionArray = {"Select session", "2018", "2019", "2020"};
    String[] branchArray = {"Select Branch", "Main", "Bashabo", "Mugda"};
    String[] classArray = {"Select class", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] shiftArray = {"Select shift", "Morning", "Day"};
    String[] sectionArray = {"Select section", "A", "B", "C"};
    String[] messageTypeArray = {"Select message type", "Bangla", "English"};
    List<StudentInfo> dataItemList = SampleDataProvider.dataItemList;
    Button btnSendSMS;

    CheckBox checkAll;
    EditText etmessage;
    List<String> checkedPhoneList, checkedAllPhoneList;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absent_message);
        setTitle("Absent Message");

        spinnerSession = (Spinner) findViewById(R.id.spinnerSession);
        spinnerBranch = (Spinner) findViewById(R.id.spinnerBranch);
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);
        spinnerShift = (Spinner) findViewById(R.id.spinnerShift);
        spinnerSection = (Spinner) findViewById(R.id.spinnerSection);
        spinnerMessageType = (Spinner) findViewById(R.id.spinnerMessageType);
        checkAll = (CheckBox) findViewById(R.id.checkAll);
        etmessage = (EditText) findViewById(R.id.etmessage);
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        checkedPhoneList = new ArrayList<>();
        checkedAllPhoneList = new ArrayList<>();


        ArrayAdapter<String> sessionAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, sessionArray);
        spinnerSession.setAdapter(sessionAdapter);


        spinnerSession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s1 = String.valueOf(spinnerSession.getSelectedItem());
                if (!s1.contentEquals("Select session")) {
                    ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(AbsentMessage.this, R.layout.spinner_item, branchArray);
                    branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    branchAdapter.notifyDataSetChanged();
                    spinnerBranch.setAdapter(branchAdapter);

                    spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String s1 = String.valueOf(spinnerBranch.getSelectedItem());
                            if (!s1.contentEquals("Select Branch")) {
                                ArrayAdapter<String> classAdapter = new ArrayAdapter<>(AbsentMessage.this, R.layout.spinner_item, classArray);
                                spinnerClass.setAdapter(classAdapter);

                                spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String s1 = String.valueOf(spinnerClass.getSelectedItem());
                                        if (!s1.contentEquals("Select class")) {
                                            ArrayAdapter<String> shiftAdapter = new ArrayAdapter<>(AbsentMessage.this, R.layout.spinner_item, shiftArray);
                                            spinnerShift.setAdapter(shiftAdapter);

                                            spinnerShift.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String s1 = String.valueOf(spinnerShift.getSelectedItem());
                                                    if (!s1.contentEquals("Select shift")) {
                                                        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<>(AbsentMessage.this, R.layout.spinner_item, sectionArray);
                                                        spinnerSection.setAdapter(sectionAdapter);
                                                        spinnerSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                            @Override
                                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                String s1 = String.valueOf(spinnerSection.getSelectedItem());
                                                                if (!s1.contentEquals("Select section")) {
                                                                    ArrayAdapter<String> messageTypeAdapter = new ArrayAdapter<>(AbsentMessage.this, R.layout.spinner_item, messageTypeArray);
                                                                    spinnerMessageType.setAdapter(messageTypeAdapter);
                                                                    spinnerMessageType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                        @Override
                                                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                            String s1 = String.valueOf(spinnerMessageType.getSelectedItem());
                                                                            if (!s1.contentEquals("Select message type")) {
                                                                                findViewById(R.id.smsContainer).setVisibility(View.VISIBLE);
                                                                            } else {
                                                                                findViewById(R.id.smsContainer).setVisibility(View.GONE);
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onNothingSelected(AdapterView<?> parent) {

                                                                        }
                                                                    });
                                                                }
                                                            }

                                                            @Override
                                                            public void onNothingSelected(AdapterView<?> parent) {

                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else {
                    spinnerBranch.setAdapter(null);
                    spinnerClass.setAdapter(null);
                    spinnerShift.setAdapter(null);
                    spinnerSection.setAdapter(null);
                    spinnerMessageType.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);

        recyclerView.setAdapter(adapter);


        checkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    for (int i = 0; i < dataItemList.size(); i++) {
                        dataItemList.get(i).setChecked(true);
                        DataItemAdapter.phones.clear();
                        checkedAllPhoneList.add(dataItemList.get(i).getPhone());

                    }
                    DataItemAdapter adapter = new DataItemAdapter(AbsentMessage.this, dataItemList);
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
                    recyclerView.setAdapter(adapter);
                } else {

                    for (int i = 0; i < dataItemList.size(); i++) {
                        dataItemList.get(i).setChecked(false);
                        checkedAllPhoneList.clear();
                    }
                    DataItemAdapter adapter = new DataItemAdapter(AbsentMessage.this, dataItemList);
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
                    recyclerView.setAdapter(adapter);
                }
            }
        });


        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkedPhoneList = DataItemAdapter.phones;
                if (checkedPhoneList.size() > 0) {
                    for (int i = 0; i < checkedPhoneList.size(); i++) {
                        Toast.makeText(AbsentMessage.this, "your number " + checkedPhoneList.get(i), Toast.LENGTH_SHORT).show();
                        SmsManager sms = SmsManager.getDefault();
                        message = etmessage.getText().toString();

                        sms.sendTextMessage(checkedPhoneList.get(i), null, message, null, null);

                    }
/*
                    String numbers[] = {"01717121839", "01766228554"};
                    for(String number : numbers) {
                        sms.sendTextMessage(number, null, message, null, null);
                    }*/
                }
                if (checkedAllPhoneList.size() > 0) {
                    for (int i = 0; i < checkedAllPhoneList.size(); i++) {
                        Toast.makeText(AbsentMessage.this, "your number " + checkedAllPhoneList.get(i), Toast.LENGTH_SHORT).show();
                        SmsManager sms = SmsManager.getDefault();
                        message = etmessage.getText().toString();

                        sms.sendTextMessage(checkedAllPhoneList.get(i), null, message, null, null);

                    }
                }

            }
        });

    }


}
