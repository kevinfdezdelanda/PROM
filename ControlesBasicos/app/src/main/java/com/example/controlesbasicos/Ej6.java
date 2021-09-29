package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Ej6 extends AppCompatActivity {

    private Switch camara1, luz1;
    private ToggleButton camara2, luz2;
    private ImageView c1, c2, l1, l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej6);

        camara1 = (Switch) findViewById(R.id.camaras);
        luz1 = (Switch) findViewById(R.id.luces);
        camara2 = (ToggleButton) findViewById(R.id.camara2);
        luz2 = (ToggleButton) findViewById(R.id.luz2);
        c1 = (ImageView) findViewById(R.id.imgC1);
        c2 = (ImageView) findViewById(R.id.imgC2);
        l1 = (ImageView) findViewById(R.id.imgL1);
        l2 = (ImageView) findViewById(R.id.imgL2);
    }


    public void accion(View v){
        if(camara1.isChecked()){
            c1.setImageResource(R.drawable.camara);
        }else{
            c1.setImageResource(0);
        }
        if(luz1.isChecked()){
            l1.setImageResource(R.drawable.bombilla_encendida);
        }else{
            l1.setImageResource(R.drawable.bombilla_apagada);
        }
        if(camara2.isChecked()){
            c2.setImageResource(R.drawable.camara);
        }else{
            c2.setImageResource(0);
        }
        if(luz2.isChecked()){
            l2.setImageResource(R.drawable.bombilla_encendida);
        }else{
            l2.setImageResource(R.drawable.bombilla_apagada);
        }
    }

}