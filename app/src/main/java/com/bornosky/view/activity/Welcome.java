package com.bornosky.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bornosky.R;

public class Welcome extends AppCompatActivity {

    TextView signin;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        signin = (TextView)findViewById(R.id.signin);
        signup = (TextView)findViewById(R.id.Signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Welcome.this, signup.class);
                startActivity(it);

            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Welcome.this,signin.class);
                startActivity(it);


            }
        });

    }
}
