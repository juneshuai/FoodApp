package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton backBtn;
    Button buyBtn;

    TextView name;
    TextView price;
    ImageView image;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        toolbar = findViewById(R.id.detail_toolbar);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buyBtn = findViewById(R.id.buy_btn);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_intent = new Intent(DetailActivity.this, MainActivity.class);
                Toast.makeText(DetailActivity.this,"Thank you for your purchase", Toast.LENGTH_SHORT).show();
                startActivity(main_intent);

            }
        });

        name = findViewById(R.id.detail_text);
        price = findViewById(R.id.detail_price);
        image = findViewById(R.id.detail_image);

        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        Glide.with(this).load(intent.getStringExtra("url")).into(image);
    }
}
