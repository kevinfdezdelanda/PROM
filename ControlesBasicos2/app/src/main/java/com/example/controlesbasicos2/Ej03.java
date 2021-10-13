package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej03 extends AppCompatActivity {

    private EditText nombre, apellidos;
    private RadioButton masculino, femenino;
    private CheckBox musica, lectura, deporte, viajar;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej03);

        nombre = (EditText) findViewById(R.id.nombre03);
        apellidos = (EditText) findViewById(R.id.apellido03);

        masculino = (RadioButton) findViewById(R.id.masculino);
        femenino = (RadioButton) findViewById(R.id.femenino);

        musica = (CheckBox) findViewById(R.id.musica);
        lectura = (CheckBox) findViewById(R.id.lectura);
        deporte = (CheckBox) findViewById(R.id.deportes);
        viajar = (CheckBox) findViewById(R.id.viajar);

        enviar = (Button) findViewById(R.id.enviar);
    }

    public void enviar(View v){
        if(v.equals(enviar)){
            String error = comprobar();
            if(error.equals("")){

            }else{

            }
        }

    }

    public String comprobar(){
        String error = "";
        if(String.valueOf(nombre.getText()).equals("")){
            error = "El nombre no puede estar vacio\n";
        }

        if(String.valueOf(apellidos.getText()).equals("")){
            error += "Los apellidos no pueden estar vacios\n";
        }

        if(!masculino.isChecked() && !femenino.isChecked()){
            error += "Debes seleccionar un sexo\n";
        }

        return error;
    }

}
