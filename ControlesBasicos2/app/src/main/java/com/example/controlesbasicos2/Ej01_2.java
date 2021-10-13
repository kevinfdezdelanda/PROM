package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej01_2 extends AppCompatActivity {

    private TextView mensaje;
    private Button aceptar, rechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej01_2);

        mensaje = (TextView) findViewById(R.id.mensaje);
        aceptar = (Button) findViewById(R.id.aceptarEj01);
        rechazar = (Button) findViewById(R.id.rechazarEj);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");

        mensaje.setText("Hola "+nombre+" "+apellidos+" ¿Aceptas las condiciones?");
    }

    public void aceptarRechazar(View v){
        Intent intent = new Intent(Ej01_2.this, Ej01.class);
        if(v.equals(aceptar)){
            setResult(RESULT_OK, intent);
            finish();
        }else if (v.equals(rechazar)){
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }


}
