package com.example.elderlymobileguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class SearchApps extends AppCompatActivity {
    ImageButton clockButton;
    ImageButton messageButton;
    ImageButton phoneButton;
    ImageButton galleryButton;
    ImageButton internetButton;
    ImageButton youtubeButton;
    ImageButton mapsButton;
    ImageButton calendarButton;
    ImageButton emailButton;
    ImageButton contactButton;
    ImageButton settingButton;
    Button tutorBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps_shortcut);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.menuHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menuHome:
                        break;
                    case R.id.menuAccount:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        break;
                    case R.id.menuSettings:
                        startActivity(new Intent(getApplicationContext(),Settings.class));
                        break;
                }
                return false;
            }
        });




        tutorBtn = findViewById(R.id.tutorialBtn5);
        tutorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppshortcutPopup.class));
            }
        });




        clockButton = (ImageButton) findViewById(R.id.clockIcon);
        clockButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, ClockDescription.class);
            startActivity(intent);
        });
        messageButton = (ImageButton) findViewById(R.id.messageIcon);
        messageButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, MessageDescription.class);
            startActivity(intent);
        });
        phoneButton = (ImageButton) findViewById(R.id.callIcon);
        phoneButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, CallDescription.class);
            startActivity(intent);
        });
        galleryButton = (ImageButton) findViewById(R.id.galleryIcon);
        galleryButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, GalleryDescription.class);
            startActivity(intent);
        });
        internetButton = (ImageButton) findViewById(R.id.internetIcon);
        internetButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, InternetDescription.class);
            startActivity(intent);
        });
        youtubeButton = (ImageButton) findViewById(R.id.youtubeIcon);
        youtubeButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, YoutubeDescription.class);
            startActivity(intent);
        });
        mapsButton = (ImageButton) findViewById(R.id.mapsIcon);
        mapsButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, MapsDescription.class);
            startActivity(intent);
        });
        calendarButton = (ImageButton) findViewById(R.id.calendarIcon);
        calendarButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, CalendarDescription.class);
            startActivity(intent);
        });
        emailButton = (ImageButton) findViewById(R.id.emailIcon);
        emailButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, EmailDescription.class);
            startActivity(intent);
        });
        contactButton = (ImageButton) findViewById(R.id.contactIcon);
        contactButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, ContactDescription.class);
            startActivity(intent);
        });
        settingButton = (ImageButton) findViewById(R.id.settingIcon);
        settingButton.setOnClickListener(v ->  {
            Intent intent = new Intent(this, SettingDescription.class);
            startActivity(intent);
        });
    }



}
