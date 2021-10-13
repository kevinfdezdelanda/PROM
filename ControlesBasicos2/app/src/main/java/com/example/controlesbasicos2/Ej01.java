package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej01  extends AppCompatActivity {

    private Button volverBtn, verificarBtn;
    private EditText nombre, apellidos;
    private TextView aceptadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej01);

        volverBtn = (Button) findViewById(R.id.volverEj01);
        verificarBtn = (Button) findViewById(R.id.verificar);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        aceptadas = (TextView) findViewById(R.id.aceptadas);

    }

    public void volver(View v){
        if(v.equals(volverBtn)){
            Intent intent = new Intent(Ej01.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void verificar(View v){
        if(v.equals(verificarBtn)){
            String nom = nombre.getText().toString();
            String ape = apellidos.getText().toString();

            if(!nom.equals("") && !ape.equals("")){
                Intent intent = new Intent(Ej01.this, Ej01_2.class);
                intent.putExtra("nombre", nom+"");
                intent.putExtra("apellidos", ape+"");
                startActivityForResult(intent,1);
            }
        }
    }

    protected void onActivityResult (int requestCode, int resultCode,
                                     Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            aceptadas.setText("Aceptadas condiciones: ACEPTADO");
        } else {
            aceptadas.setText("Aceptadas condiciones: RECHAZADO");
        }
    }
}
