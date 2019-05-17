package com.bornosky.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bornosky.MainActivity;
import com.bornosky.R;

public class signin extends AppCompatActivity {

    TextView create;

    Typeface fonts1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        create = (TextView)findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this, signup.class);
                startActivity(it);

            }
        });




        fonts1 =  Typeface.createFromAsset(signin.this.getAssets(),
                "fonts/Lato-Regular.ttf");




        TextView t4 =(TextView)findViewById(R.id.create);
        t4.setTypeface(fonts1);




    }

    public void clickSignin(View view) {
        startActivity(new Intent(signin.this, MainActivity.class));

    }
}
