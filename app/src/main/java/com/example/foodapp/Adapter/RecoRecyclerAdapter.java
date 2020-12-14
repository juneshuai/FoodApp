package com.example.foodapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Model.Reco;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RecoRecyclerAdapter extends RecyclerView.Adapter<RecoViewHolder> {

    private Context context;
    private ArrayList<Reco> product;

    public RecoRecyclerAdapter(ArrayList<Reco> product){
        this.product = product;
    }

    @NonNull
    @Override
    public RecoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.reco_food_card,parent,false);
        RecoViewHolder viewHolder = new RecoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecoViewHolder holder, int position) {
        holder.name.setText(product.get(position).name);
        holder.price.setText(product.get(position).price);

        String url = product.get(position).url;
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return product.size();
    }
}
