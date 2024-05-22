package com.malkinfo.rentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * UpdateProfile activity allows users to update their profile information.
 */
public class UpdateProfile extends AppCompatActivity {

    private DatabaseReference ref;
    private EditText Name, Email, Username, Password;
    private TextView profilename;
    private ImageView Image;
    private Button Button;
    private String uname;

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        // Initialize UI components
        Name = findViewById(R.id.profileName);
        Email = findViewById(R.id.profileEmail);
        Username = findViewById(R.id.profileUsername);
        Password = findViewById(R.id.profilePassword);
        profilename = findViewById(R.id.titleUsername);
        Button = findViewById(R.id.editButton);
        Image = findViewById(R.id.profileImg);

        // Get the username passed from the previous activity
        uname = getIntent().getStringExtra("username");
        profilename.setText(uname);

        // Load profile image using Glide
        Glide.with(UpdateProfile.this)
                .load(R.drawable.baseline_account_circle_24)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(Image);

        // Initialize Firebase Database reference
        ref = FirebaseDatabase.getInstance().getReference().child("users").child(uname);

        // Set click listener for the update button
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the updated user information from the input fields
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                // Create a UserClass object with the updated information
                UserClass userClass = new UserClass(name, email, username, password);

                // Update the user information in the Firebase database
                ref.setValue(userClass);

                // Start the ProfileActivity and pass the username
                Intent intent = new Intent(UpdateProfile.this, ProfileActivity.class);
                intent.putExtra("username", uname);
                startActivity(intent);
            }
        });
    }
}
