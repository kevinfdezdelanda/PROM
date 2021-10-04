package com.example.controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Ej7 extends AppCompatActivity {

    private Switch camara, luz;
    private SeekBar temperatura, persianas;
    private ImageView c, l;
    private ProgressBar p;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej7);

        camara = (Switch) findViewById(R.id.camaras);
        luz = (Switch) findViewById(R.id.luces);
        temperatura = (SeekBar) findViewById(R.id.temperatura);
        persianas = (SeekBar) findViewById(R.id.persianas);
        c = (ImageView) findViewById(R.id.imgC1);
        l = (ImageView) findViewById(R.id.imgL1);
        p = (ProgressBar) findViewById(R.id.per);
        t = (TextView) findViewById(R.id.temp);

        persianas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int progreso = persianas.getProgress();
                p.setProgress(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        temperatura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int progreso = temperatura.getProgress();
                if(progreso<127){
                    t.setBackgroundColor(Color.rgb(0+progreso*2, 0+progreso*2, 255-progreso*2));
                    //t.setBackgroundColor(Color.rgb(126,126,126));
                }else{
                    t.setBackgroundColor(Color.rgb(0+progreso, 255-progreso*2, 255-progreso));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void accion(View v){
        if(camara.isChecked()){
            c.setImageResource(R.drawable.camara);
        }else{
            c.setImageResource(0);
        }
        if(luz.isChecked()){
            l.setImageResource(R.drawable.bombilla_encendida);
        }else{
            l.setImageResource(R.drawable.bombilla_apagada);
        }
        if(v.equals(persianas)){

        }

    }

}