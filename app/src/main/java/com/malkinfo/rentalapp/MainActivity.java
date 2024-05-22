package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * The MainActivity represents the main screen of the rental application.
 * It displays options for navigating to different sections of the application.
 */
public class MainActivity extends AppCompatActivity {

    private RelativeLayout home, car;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        home = findViewById(R.id.homeAct);
        car = findViewById(R.id.carAct);


        String uname = getIntent().getStringExtra("username");


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the HomesActivity and pass the username
                Intent intent = new Intent(MainActivity.this, HomesActivity.class);
                intent.putExtra("username", uname);
                startActivity(intent);
            }
        });

        // Set click listener for the car option
        /*car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the CarsActivity
                Intent intent = new Intent(MainActivity.this, CarsActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
