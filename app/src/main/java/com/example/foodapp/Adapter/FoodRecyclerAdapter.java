package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.DetailActivity;
import com.example.foodapp.Model.Reco;
import com.example.foodapp.R;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Context context;
    private ArrayList<Reco> product;

    public FoodRecyclerAdapter(ArrayList<Reco> product){
        this.product = product;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.food_card,parent,false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.name.setText(product.get(position).name);
        holder.price.setText(product.get(position).price);

        String url = product.get(position).url;
        Glide.with(context).load(url).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("name",holder.name.getText());
                intent.putExtra("url",url);
                intent.putExtra("price",holder.price.getText());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return product.size();
    }
}
