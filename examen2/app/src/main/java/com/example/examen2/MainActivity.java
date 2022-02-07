package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ej1 = findViewById(R.id.btnEj1);
        ej1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ej1.class);
                startActivity(intent);
            }
        });

        Button ej2 = findViewById(R.id.btnEj2);
        ej2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ej2.class);
                startActivity(intent);
            }
        });

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(view -> new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.adios)
                .setMessage(R.string.adios)
                .setCancelable(false)
                .setPositiveButton(R.string.salir, (dialogInterface, i) -> finish())
                .show());
    }
}