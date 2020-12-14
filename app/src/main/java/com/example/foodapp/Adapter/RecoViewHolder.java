package com.example.foodapp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;

public class RecoViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView image;
    TextView price;

    public RecoViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.reco_name);
        image = itemView.findViewById(R.id.reco_image);
        price = itemView.findViewById(R.id.reco_price);
    }
}
