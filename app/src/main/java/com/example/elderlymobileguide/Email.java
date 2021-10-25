package com.example.elderlymobileguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Email extends AppCompatActivity {

    EditText emailDestination,emailSubject,emailContent;
    Button sendBtn,tutorialBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        emailDestination = findViewById(R.id.emailDestination);
        emailSubject = findViewById(R.id.emailSubject);
        emailContent = findViewById(R.id.emailContent);
        sendBtn = findViewById(R.id.sendBtn);
        tutorialBtn = findViewById(R.id.tutorialBtn3);

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


        tutorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmailPopup.class));
            }
        });


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailDestination.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,emailContent.getText().toString());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }



            }
        });

    }




}

