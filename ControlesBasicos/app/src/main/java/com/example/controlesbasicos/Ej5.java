package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej5 extends AppCompatActivity implements View.OnClickListener{

    private Button google, yahoo, bing;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej5);

        image = (ImageView) findViewById(R.id.imageView);
        google = (Button) findViewById(R.id.google);
        bing = (Button) findViewById(R.id.bing);
        yahoo = (Button) findViewById(R.id.yahoo);
        yahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.yahoo_logo);
            }
        });
    }

    public void cambiarImg(View v){
        if(v.equals(bing)){
            image.setImageResource(R.drawable.bing_logo);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.equals(google)){
            image.setImageResource(R.drawable.google_logo);
        }
    }
}