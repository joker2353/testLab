package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

/**
 * The Show_Payment class represents an activity that displays the result of a payment transaction.
 */
public class Show_Payment extends AppCompatActivity {
    private String st;
    private TextView textView;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_payment);


        textView = findViewById(R.id.show_payment);


        st = getIntent().getStringExtra("show_payment");


        textView.setText(st);
    }
}
