package com.malkinfo.rentalapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.malkinfo.rentalapp.DetailsActivity;
import com.malkinfo.rentalapp.HomeAdapter;
import com.malkinfo.rentalapp.Item;
import com.malkinfo.rentalapp.R;
import com.malkinfo.rentalapp.UserClass;
import com.malkinfo.rentalapp.listeners.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The HomesActivity class displays a list of available homes.
 */
public class HomesActivity extends AppCompatActivity implements ItemListener {

    private RecyclerView topDealRv;
    private HomeAdapter adapter;
    ArrayList<HomeModal> itemList = new ArrayList<HomeModal>();

    private CircleImageView profileImage;
    public TextView username,useremail;

    FirebaseDatabase database;
    DatabaseReference ref;
    Button updateButton;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        topDealRv = findViewById(R.id.top_deal_RV);
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.user_name);

        uname= getIntent().getStringExtra("username");
        username.setText(uname);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomesActivity.this,ProfileActivity.class);
                intent.putExtra("username",uname );
                startActivity(intent);
            }
        });

        ref = database.getInstance().getReference().child("users");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                UserClass user=snapshot.getValue(UserClass.class);

                if(user!=null){
                    Glide.with(HomesActivity.this)
                            .load(user.getImage())
                            .centerCrop()
                            .placeholder(R.drawable.baseline_account_circle_24)
                            .into(profileImage);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        FirebaseDatabase.getInstance().getReference().child("homes")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        itemList.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            HomeModal homeModal = dataSnapshot.getValue(HomeModal.class);
                            if (homeModal != null) {
                                itemList.add(homeModal);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("FirebaseError", "Database error: " + error.getMessage());
                    }
                });

        adapter = new HomeAdapter(HomesActivity.this, itemList, HomesActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomesActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        topDealRv.setLayoutManager(linearLayoutManager);
        topDealRv.setAdapter(adapter);
    }

    /**
     * Callback method invoked when an item is clicked.
     * @param position The position of the clicked item.
     */
    @Override
    public void OnItemPosition(int position){
        Intent intent = new Intent(HomesActivity.this, DetailsActivity.class);
        HomeModal homeModal = itemList.get(position);
        intent.putExtra("price",homeModal.price);
        intent.putExtra("location",homeModal.location);
        intent.putExtra("description",homeModal.description);
        intent.putExtra("shortDescription",homeModal.shortDescription);
        intent.putExtra("image",homeModal.image);
        startActivity(intent);
    }
}
