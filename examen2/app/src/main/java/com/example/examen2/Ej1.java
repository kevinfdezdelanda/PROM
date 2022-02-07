package com.example.examen2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ej1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1);

        //Abrimos la base de datos "DBUsuarios" en modo de escritura
        ClientesSQLiteHelper usdbh =
                new ClientesSQLiteHelper(this, "DBClientes2", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        Button ej1_1 = findViewById(R.id.btnEj1_1);
        ej1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ej1.this, Ej1_1.class);
                startActivity(intent);
            }
        });

        Button ej1_2 = findViewById(R.id.btnEj1_2);
        ej1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ej1.this, Ej1_2.class);
                startActivity(intent);
            }
        });

        Button ej1_3 = findViewById(R.id.btnEj1_3);
        ej1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ej1.this, Ej1_3.class);
                startActivity(intent);
            }
        });


    }
}