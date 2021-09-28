package com.example.controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Ej3 extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej3);

        layout = (LinearLayout) findViewById(R.id.layout);
    }

    public void encender(View v){
        layout.setBackgroundColor(Color.YELLOW);
    }

    public void apagar(View v){
        layout.setBackgroundColor(Color.BLACK);
    }

}