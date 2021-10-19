package com.example.listas_e_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button a01,a02,a03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a01 = (Button) findViewById(R.id.a01);
        a02 = (Button) findViewById(R.id.a02);
        a03 = (Button) findViewById(R.id.a03);
    }

    public void cambiarActividad(View v){
        if(v.equals(a01)){
            Intent intent = new Intent(MainActivity.this, Ej01.class);
            startActivity(intent);
        }

        if(v.equals(a02)){
            Intent intent = new Intent(MainActivity.this, Ej02.class);
            startActivity(intent);
        }

        if(v.equals(a03)){
            Intent intent = new Intent(MainActivity.this, Ej03.class);
            startActivity(intent);
        }
    }
}