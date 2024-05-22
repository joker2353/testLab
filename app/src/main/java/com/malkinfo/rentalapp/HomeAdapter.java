package com.malkinfo.rentalapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.malkinfo.rentalapp.listeners.ItemListener;

import java.util.ArrayList;

/**
 * The HomeAdapter class is a RecyclerView adapter responsible for populating the home listings in a RecyclerView.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HomeModal> itemList;
    private ItemListener itemListener;

    /**
     * Constructs a new HomeAdapter.
     * @param context The context of the activity or fragment.
     * @param itemList The list of home listings to be displayed.
     * @param itemListener The item click listener for handling clicks on home listings.
     */
    public HomeAdapter(Context context, ArrayList<HomeModal> itemList, ItemListener itemListener) {
        this.context = context;
        this.itemList = itemList;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.top_deals, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.price.setText(itemList.get(position).price);
        holder.location.setText(itemList.get(position).location);
        holder.shortDescription.setText(itemList.get(position).description);
        Glide.with(context)
                .load(itemList.get(position).image)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.relativeLayout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * The ViewHolder class represents a single item view in the RecyclerView.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView price, location, shortDescription;
        public RelativeLayout relativeLayout;

        /**
         * Constructs a new ViewHolder.
         * @param itemView The view representing a single item in the RecyclerView.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            location = itemView.findViewById(R.id.location);
            shortDescription = itemView.findViewById(R.id.short_description);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.OnItemPosition(getAdapterPosition());
                }
            });
        }
    }
}
