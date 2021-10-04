package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button a01,a02,a03,a04,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a01 = (Button) findViewById(R.id.a01);
        a02 = (Button) findViewById(R.id.a02);
        a03 = (Button) findViewById(R.id.a03);
        a04 = (Button) findViewById(R.id.a04);
        salir = (Button) findViewById(R.id.salir);
    }

    public void cambiarActividad(View v){
        if(v.equals(a01)){
            Intent intent = new Intent(MainActivity.this, Ej01.class);
            startActivity(intent);
        }
    }
}