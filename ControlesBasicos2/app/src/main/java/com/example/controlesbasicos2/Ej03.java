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
    private TextView txtError;

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
        txtError = (TextView) findViewById(R.id.error);

        enviar = (Button) findViewById(R.id.enviar);
    }

    public void enviar(View v){
        if(v.equals(enviar)){
            String error = comprobar();
            if(error.equals("")){
                txtError.setText("");
                Intent intent = new Intent(Ej03.this, Ej03_2.class);
                intent.putExtra("nombre", String.valueOf(nombre.getText()));
                intent.putExtra("apellido", String.valueOf(apellidos.getText()));
                if(masculino.isChecked()){
                    intent.putExtra("sexo", "masculino");
                }else{
                    intent.putExtra("sexo", "femenino");
                }
                String aficiones = "";

                if(musica.isChecked()){
                    aficiones += "musica ";
                }

                if(lectura.isChecked()){
                    aficiones += "lectura ";
                }

                if(deporte.isChecked()){
                    aficiones += "deporte ";
                }

                if(viajar.isChecked()){
                    aficiones += "viajar ";
                }

                intent.putExtra("aficiones", aficiones);

                startActivity(intent);
            }else{
                txtError.setText(error);
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
