package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej04_2 extends AppCompatActivity {

    private TextView precio;
    private Button cancelar, pagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej04_2);

        cancelar = (Button) findViewById(R.id.cancelar04);
        pagar = (Button) findViewById(R.id.pagar);

        precio = (TextView) findViewById(R.id.precioTotal);

        Bundle extras = getIntent().getExtras();
        int kebabs = extras.getInt("kebabs");
        int durums = extras.getInt("durums");
        int pPequeñas = extras.getInt("pPequeñas");
        int pGrandes = extras.getInt("pGrandes");

        double total = (kebabs*3.5) + (durums*4.5) + (pPequeñas*2) + (pGrandes*3);
        precio.setText(total+"€");
    }

    public void accion04(View v){
        Intent intent = new Intent(Ej04_2.this, Ej04.class);
        if(v.equals(pagar)){
            setResult(RESULT_OK, intent);
            finish();
        }else{
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }


}
