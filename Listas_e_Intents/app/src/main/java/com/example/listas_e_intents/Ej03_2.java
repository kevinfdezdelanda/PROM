package com.example.listas_e_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej03_2 extends AppCompatActivity {

    private Spinner tipo;
    private EditText nombre;
    private EditText correoTelf;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej03_2);

        tipo = (Spinner) findViewById(R.id.tipo);
        nombre = (EditText) findViewById(R.id.nombreCont);
        correoTelf = (EditText) findViewById(R.id.correoTelf);
        error = (TextView) findViewById(R.id.error03);

        //Creamos el Array
        final String[] datos = new String [] {"Telefono","Correo"} ;
        //Creamos el adaptador para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
    }

    public void crearCont(View v){
        boolean esCorreo = false;
        if(tipo.getSelectedItemPosition()!=0){
            esCorreo = true;
        }

        String strNombre = nombre.getText().toString();
        String strCorreoTelf = correoTelf.getText().toString();
        if (strCorreoTelf.equals("") || strNombre.equals("")){
            error.setText("Debes rellenar todos los campos");
        }else{
            Intent intent = new Intent(Ej03_2.this, Ej03.class);
            intent.putExtra("nombre", strNombre);
            intent.putExtra("correoTelf", strCorreoTelf);
            intent.putExtra("esCorreo", esCorreo);
            startActivity(intent);
        }

    }


}