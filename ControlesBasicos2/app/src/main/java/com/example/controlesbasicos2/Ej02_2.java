package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej02_2 extends AppCompatActivity {

    private TextView dResul;
    private Button volver;
    private boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej02_2);

        dResul = (TextView) findViewById(R.id.dResul);
        volver = (Button) findViewById(R.id.volver02);

        Bundle extras = getIntent().getExtras();
        int num1 = extras.getInt("num1");
        int num2 = extras.getInt("num2");
        int resulUsu = extras.getInt("resulUsu");

        if((num1+num2)==resulUsu){
            dResul.setText("CORRECTO");
            correcto = true;
        }else{
            dResul.setText("INCORRECTO");
            correcto = false;
        }
    }

    public void volver02(View v){
        Intent intent = new Intent(Ej02_2.this, Ej02.class);
        if(v.equals(volver)){
            if(correcto){
                setResult(RESULT_OK, intent);
                finish();
            }else{
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        }
    }



}
