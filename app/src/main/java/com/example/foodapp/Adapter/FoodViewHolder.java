package com.example.foodapp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView image;
    TextView price;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.food_name);
        image = itemView.findViewById(R.id.food_image);
        price = itemView.findViewById(R.id.food_price);
    }
}
