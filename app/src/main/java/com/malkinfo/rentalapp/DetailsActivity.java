package com.malkinfo.rentalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/**
 * DetailsActivity displays the details of a selected item and allows the user to apply for it.
 */
public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView price, shortDescription, description;
    private Button apply;
    private String pri, des, shdes, img, selectedHouseType, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize views
        imageView = findViewById(R.id.imageView);
        price = findViewById(R.id.price);
        shortDescription = findViewById(R.id.short_description);
        description = findViewById(R.id.description);
        apply = findViewById(R.id.applying);

        // Retrieve data from intent
        pri = getIntent().getStringExtra("price");
        des = getIntent().getStringExtra("description");
        shdes = getIntent().getStringExtra("shortDescription");
        img = getIntent().getStringExtra("image");
        id = getIntent().getStringExtra("id");

        // Display item details
        price.setText(pri);
        description.setText(des);
        shortDescription.setText(shdes);

        Glide.with(this)
                .load(img)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(imageView);


        String[] houseTypes = getResources().getStringArray(R.array.RoomType);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, houseTypes);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedHouseType = parent.getItemAtPosition(position).toString();
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, Checkout.class);
                Toast.makeText(DetailsActivity.this, selectedHouseType, Toast.LENGTH_SHORT).show();


                FeatureType featureType = FeatureFactory.getfeature(selectedHouseType);
                House house = HouseFactory.gethouseType(shdes, featureType);
                String orderDetails = house.getHouseDetails();
                OrderClass order = new OrderClass(id, orderDetails);

                // Save order to Firebase
                TreeFactory treeFactory = new TreeFactory();
                DatabaseReference ref = treeFactory.getFirebaseTree("orders");
                ref.child(UUID.randomUUID().toString()).setValue(order);

                startActivity(intent);
            }
        });
    }
}
