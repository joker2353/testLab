package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Checkout activity allows users to choose a payment method for their order.
 */
public class Checkout extends AppCompatActivity {

    private RelativeLayout paypal, ssl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Initialize views
        paypal = findViewById(R.id.paypal);
        ssl = findViewById(R.id.ssl);

        // Set click listeners for payment options
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open PayPal payment activity
                Intent intent = new Intent(Checkout.this, Payment.class);
                startActivity(intent);
            }
        });

        ssl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open SSLCommerz payment activity
                Intent intent = new Intent(Checkout.this, sslcommerzActivity.class);
                startActivity(intent);
            }
        });
    }
}
