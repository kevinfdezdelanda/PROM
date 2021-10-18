package com.example.listas_e_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Ej01 extends AppCompatActivity {

    private Spinner paises;
    private TextView numHabitantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej01);

        paises = (Spinner) findViewById(R.id.paises);
        numHabitantes = (TextView) findViewById(R.id.numHabitantes);

        HashMap<String, String> habitantesPais = new HashMap<>();
        habitantesPais.put("España", "47,35 millones (2020)");
        habitantesPais.put("Italia", "59,55 millones (2020)");
        habitantesPais.put("Holanda", "17,44 millones (2020)");
        habitantesPais.put("Alemania", "83,24 millones (2020)");
        habitantesPais.put("Portugal", "10,31 millones (2020)");
        habitantesPais.put("Inglaterra", "55,98 millones (2018)");

        //Creamos el Array
        final String[] datos = new String [] {"España" ,"Italia",
                "Holanda", "Alemania", "Portugal", "Inglaterra"} ;
        //Creamos el adaptador para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        paises.setAdapter(adaptador);

        paises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                numHabitantes.setText (habitantesPais.get(parent.getItemAtPosition(position)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                numHabitantes.setText("");
            }
        });
    }


}