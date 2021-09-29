package com.example.controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej4 extends AppCompatActivity {

    private Button boton;
    private EditText num, letra;
    private TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej4);

        boton = (Button) findViewById(R.id.validar);
        num = (EditText) findViewById(R.id.numDni);
        letra = (EditText) findViewById(R.id.letra);
        resul = (TextView) findViewById(R.id.result);
    }


    public void validar(View v){
        try{
            String strDni = String.valueOf(num.getText());
            if(strDni.length()!=8){
                throw new Exception("Numero DNI no valido");
            }
            String letraDni = String.valueOf(letra.getText());
            int numDni = Integer.parseInt(strDni);
            char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
            int resto = numDni%23;
            char l = caracteres[resto];
            if(!letraDni.equals(l+"")){
                throw new Exception("Letra DNI no valida");
            }

            resul.setText("DNI VALIDO!!");
            resul.setBackgroundColor(Color.GREEN);
        }catch (Exception e){
            System.out.print(e);
            resul.setText(e.getMessage());
            resul.setBackgroundColor(Color.RED);
        }

    }

}