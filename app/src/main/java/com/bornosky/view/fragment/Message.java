package com.bornosky.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bornosky.R;
import com.bornosky.view.activity.IndividualSMS;

/**
 * A simple {@link Fragment} subclass.
 */
public class Message extends Fragment implements View.OnClickListener {


    public Message() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sms, container, false);
        view.findViewById(R.id.btnIndividualSMS).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        switch (id){
            case R.id.btnIndividualSMS:
                startActivity(new Intent(getActivity(), IndividualSMS.class));
        }

    }
}
