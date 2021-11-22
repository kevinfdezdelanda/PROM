package com.example.ej_ud02_dialogos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PedirKebab2 extends AppCompatActivity {

    private TextView precio;
    private Button cancelar, pagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedir_kebab2);

        cancelar = (Button) findViewById(R.id.cancelar04);
        pagar = (Button) findViewById(R.id.pagar);

        precio = (TextView) findViewById(R.id.precioTotal);

        Bundle extras = getIntent().getExtras();
        int kebabs = extras.getInt("kebabs");
        int durums = extras.getInt("durums");
        int pPequeñas = extras.getInt("pPequeñas");
        int pCarne = extras.getInt("pCarne");

        double total = (kebabs*3.5) + (durums*4.5) + (pPequeñas*2) + (pCarne*3.5);
        precio.setText(total+"€");
    }

    public void accion04(View v){
        Intent intent = new Intent(PedirKebab2.this, PedirKebab.class);
        if(v.equals(pagar)){
            setResult(RESULT_OK, intent);
            finish();
        }else{
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }


}
