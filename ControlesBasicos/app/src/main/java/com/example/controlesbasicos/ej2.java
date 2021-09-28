package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ej2 extends AppCompatActivity {

    private EditText valor1, valor2;
    private TextView resultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej2);

        resultado = (TextView) findViewById(R.id.resultado);
        valor1 = (EditText) findViewById(R.id.txtvalor1);
        valor2 = (EditText) findViewById(R.id.txtvalor2);
        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
    }


    public void operar(View v){
        if(!valor1.getText().toString().matches("") || !valor2.getText().toString().matches("")){
            double v1 = Double.parseDouble(String.valueOf(valor1.getText()));
            double v2 = Double.parseDouble(String.valueOf(valor2.getText()));

            if(v.equals(btnSumar)){
                resultado.setText("Resultado: "+(v1+v2));
            }else if (v.equals(btnRestar)){
                resultado.setText("Resultado: "+(v1-v2));
            }else if (v.equals(btnMultiplicar)){
                resultado.setText("Resultado: "+(v1*v2));
            }else if (v.equals(btnDividir)){
                if( v1 == 0 || v2 == 0){
                    resultado.setText("Resultado: No se puede dividir entre 0");
                }else{
                    resultado.setText("Resultado: "+(v1/v2));
                }

            }

        }
    }

}