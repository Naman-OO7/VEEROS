package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.signup.databinding.ActivityLeaderboardBinding;

import java.util.ArrayList;
import java.util.List;

public class emergency extends main_page2 {

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

        userList.add(new ModelClass(R.drawable.person, "Ram", "963XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Shyam", "783XX", "Delhi,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Rashmi", "989XX", "Delhi,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Raj", "706XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Aditya", "806XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Param", "806XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Sunil", "906XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Salman", "806XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Aman", "206XX", "Agra,India", "________________"));
        userList.add(new ModelClass(R.drawable.person, "Radha", "606XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Priya", "906XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Dev", "806XX", "Agra,India", "____________________"));
        userList.add(new ModelClass(R.drawable.person, "Rahul", "906XX", "Agra,India", "____________________"));

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