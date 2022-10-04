package com.example.signup;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.signup.databinding.ActivityMainPage2Binding;
import com.google.android.material.navigation.NavigationView;

import java.util.Set;

public class main_page2 extends AppCompatActivity {
    ImageView contact1,contact2,contact3;
    ImageButton img1,img2;
    Button btn1,btn2,btn3;
    Toolbar toolbar;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    ActivityMainPage2Binding activityMainPage2Binding;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page2);
        contact1=findViewById(R.id.contact1);
        contact2=findViewById(R.id.contact2);
        contact3=findViewById(R.id.contact3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);



//        getSupportActionBar().hide();//Ocultar ActivityBar anterior

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navMenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_home,R.id.menu_leaderBoard,R.id.menu_profile).setDrawerLayout(drawerLayout).build();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_home:
                        Toast.makeText(main_page2.this, "dsfjgskjefges", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(main_page2.this, main_page2.class); //ACTIVITY_NUM=0
                        startActivity(intent1);
                        return true;

                    case R.id.menu_leaderBoard:
                        Toast.makeText(main_page2.this, "esuihfgier", Toast.LENGTH_SHORT).show();
                        Intent intent2=new Intent(main_page2.this, Leaderboard.class);//ACTIVITY_NUM=1
                        startActivity(intent2);
                        return true;

                    case R.id.menu_profile:
                        Toast.makeText(main_page2.this, "segf", Toast.LENGTH_SHORT).show();
                        Intent intent3=new Intent(main_page2.this, last_page.class);//ACTIVITY_NUM=2
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,maps.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,maps.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,maps.class));
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,Leaderboard.class));
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,last_page.class));
            }
        });


     

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,emergency.class));
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,emergency.class));
            }
        });
        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main_page2.this,emergency.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}