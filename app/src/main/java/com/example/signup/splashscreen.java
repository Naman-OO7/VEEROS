package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(splashscreen.this,LoginActivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, 1000);
    }
}