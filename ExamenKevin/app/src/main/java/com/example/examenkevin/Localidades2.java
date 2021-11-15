package com.example.examenkevin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Localidades2 extends AppCompatActivity {

    private ListView listLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localidades2);

        listLocalidades = (ListView) findViewById(R.id.list);

        ArrayList<Localidad> arrayListLocalidades = new LocalidadesArray(this).getArrayListLocalidades();
        ArrayList<Localidad> localidades = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        String zona = extras.getString("zona");
        String provincia = extras.getString("provincia");

        for(int i = 0; i < arrayListLocalidades.size(); i++){
            if(provincia.equals(arrayListLocalidades.get(i).getProvinica()) && arrayListLocalidades.get(i).getZona().equals(zona)){
                localidades.add(arrayListLocalidades.get(i));
            }
        }

        AdaptadorLocalidades adaptadorLocalidades =
                new AdaptadorLocalidades(this, localidades);
        listLocalidades.setAdapter(adaptadorLocalidades);

        listLocalidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Alternativa 1:
                Localidad localidad = ((Localidad)parent.getItemAtPosition(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(localidad.getEnlace()));
                startActivity(intent);
            }
        });

        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText("-- "+localidades.get(0).getProvinica()+" --\n"+localidades.get(0).getZona());

        Button volver = (Button) findViewById(R.id.volverlistas);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Localidades2.this, Localidades.class);
                startActivity(intent);
            }
        });
    }


}