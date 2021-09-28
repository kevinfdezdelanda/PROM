package com.example.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valor1, valor2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.resultado);
        valor1 = (EditText) findViewById(R.id.txtvalor1);
        valor2 = (EditText) findViewById(R.id.txtvalor2);
    }

    public void sumar(View v){
        if(!valor1.getText().toString().matches("") || !valor2.getText().toString().matches("")){
            double v1 = Double.parseDouble(String.valueOf(valor1.getText()));
            double v2 = Double.parseDouble(String.valueOf(valor2.getText()));
            resultado.setText("La suma es: "+(v1+v2));
        }
    }

    public void operar(View v){
        if(!valor1.getText().toString().matches("") || !valor2.getText().toString().matches("")){
            double v1 = Double.parseDouble(String.valueOf(valor1.getText()));
            double v2 = Double.parseDouble(String.valueOf(valor2.getText()));
            resultado.setText("La suma es: "+(v1+v2));
        }
    }

}