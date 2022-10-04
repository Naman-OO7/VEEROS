package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.signup.databinding.ActivityLeaderboardBinding;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard extends main_page2 {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userList;
    Adapter adapter;
    ActivityLeaderboardBinding activityLeaderboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLeaderboardBinding=ActivityLeaderboardBinding.inflate(getLayoutInflater());


        setContentView(activityLeaderboardBinding.getRoot());

        initData();
        initRecyclerView();
    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.person, "Ram", "700", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Shyam", "670", "Delhi,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Rashmi", "660", "Delhi,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Raj", "640", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Aditya", "610", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Param", "600", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Sunil", "600", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Salman", "580", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Aman", "550", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Radha", "540", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Priya", "510", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Dev", "490", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Rahul", "400", "Agra,India", "____________________"));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager((this));
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}