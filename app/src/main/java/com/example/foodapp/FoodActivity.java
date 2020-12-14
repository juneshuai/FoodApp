package com.example.foodapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Adapter.FoodRecyclerAdapter;
import com.example.foodapp.Adapter.ListRecyclerAdapter;
import com.example.foodapp.Adapter.RecoRecyclerAdapter;
import com.example.foodapp.Model.Reco;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView food_recyclerView;
    ImageButton backBtn;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Reco> product = new ArrayList<Reco>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        toolbar = findViewById(R.id.food_toolbar);
        setSupportActionBar(toolbar);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        db.collection("food").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        if(document.getData().get("title").toString().equals(intent.getStringExtra("name"))){
                            String name = document.getData().get("title").toString();
                            String url = document.getData().get("image").toString();
                            String price = document.getData().get("price").toString();
                            product.add(new Reco(name, url, price));

                        }else{
                            Log.w("sss","Error getting documents.",task.getException());
                        }
                    }
                }
            }
        });

        food_recyclerView = findViewById(R.id.food_recycler);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FoodRecyclerAdapter foodRecyclerAdapter = new FoodRecyclerAdapter(product);
                food_recyclerView.setAdapter(foodRecyclerAdapter);
                food_recyclerView.setLayoutManager(linearLayoutManager);
            }
        }, 3000);


    }
}
