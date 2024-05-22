package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * The sslcommerzActivity class represents an activity for selecting a payment method and processing payments.
 */
public class sslcommerzActivity extends AppCompatActivity {
    private RelativeLayout card, mb;
    private TextView txt;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sslcommerz);

        // Initialize UI components
        card = findViewById(R.id.card);
        mb = findViewById(R.id.mb);

        // Create a PaymentSystem instance
        PaymentSystem paymentSystem = new PaymentSystem();

        // Set onClick listener for the credit card payment option
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the payment role to CreditCardProcessor
                paymentSystem.setPaymentRole(new CreditCardProcessor());
                // Process the payment with a fixed amount (e.g., 100)
                String paymentResult = paymentSystem.processPayment(100);
                // Start Show_Payment activity and pass the payment result
                Intent intent = new Intent(sslcommerzActivity.this, Show_Payment.class);
                intent.putExtra("show_payment", paymentResult);
                startActivity(intent);
            }
        });

        // Set onClick listener for the mobile banking payment option
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the payment role to MobileBankingProcessor
                paymentSystem.setPaymentRole(new MobileBankingProcessor());
                // Process the payment with a fixed amount (e.g., 500)
                String paymentResult = paymentSystem.processPayment(500);
                // Start Show_Payment activity and pass the payment result
                Intent intent = new Intent(sslcommerzActivity.this, Show_Payment.class);
                intent.putExtra("show_payment", paymentResult);
                startActivity(intent);
            }
        });
    }
}
