package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import com.example.signup.databinding.ActivityLastPageBinding;

public class last_page extends main_page2 {

ActivityLastPageBinding activityLastPageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLastPageBinding=ActivityLastPageBinding.inflate(getLayoutInflater());
        setContentView(activityLastPageBinding.getRoot());


    }

}