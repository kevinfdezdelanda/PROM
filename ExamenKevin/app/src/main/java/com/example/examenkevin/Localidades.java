package com.example.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class Localidades extends AppCompatActivity  {

    private Spinner spLocalidades;
    private LinearLayout linearLayout;
    private RadioButton rbCosta, rbInterior;
    private Button visualizar, volver;
    private static ArrayList<Localidad> arrayListLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.localidades);

        spLocalidades = (Spinner) findViewById(R.id.localidades);
        linearLayout = (LinearLayout) findViewById(R.id.seleccionUbicacion);
        visualizar = (Button) findViewById(R.id.visualizar);
        volver = (Button) findViewById(R.id.volverLocalidades);

        rbCosta = (RadioButton) findViewById(R.id.rbCosta);
        rbInterior = (RadioButton) findViewById(R.id.tbInterior);

        linearLayout.setVisibility(View.INVISIBLE);

        LocalidadesArray l = new LocalidadesArray(this);
        arrayListLocalidades =  l.getArrayListLocalidades();

        String[] array = {"","Bizkaia","Araba","Gipuzkoa","Nafarroa","Lapurdi","Behe-Nafarroa","Zuberoa"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, array);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spLocalidades.setAdapter(adaptador);

        spLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String seleccionado = (String) parent.getItemAtPosition(position);
                boolean tieneCosta = false;
                for(int i = 0; i < arrayListLocalidades.size(); i++){
                    if(seleccionado.equals(arrayListLocalidades.get(i).getProvinica()) && arrayListLocalidades.get(i).getZona().equals("Costa")){
                        tieneCosta = true;
                    }
                }

                if(tieneCosta){
                    linearLayout.setVisibility(View.VISIBLE);
                }else{
                    linearLayout.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        Button volver = (Button) findViewById(R.id.volverLocalidades);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Localidades.this, MainActivity.class);
                intent.putExtra("sesionIniciada", true);
                startActivity(intent);
            }
        });
    }

    public void visualizarLocalidad(View v){
        if(v.equals(visualizar)){

            String seleccionado = "Interior";
            if(rbCosta.isChecked()){
                seleccionado = "Costa";
            }

            if(spLocalidades.getSelectedItemPosition()>0){
                if (spLocalidades.getSelectedItemPosition()>3){
                    FragmentManager fragmentManager= getSupportFragmentManager();
                    DialogoInformacion dialogoInfo = new DialogoInformacion("Las localidades de esta provincia no estan disponibles actualmente. Opcion sin implementar!", false);
                    dialogoInfo.show(fragmentManager,"tagAlerta");
                }else{
                    Intent intent = new Intent(Localidades.this, Localidades2.class);
                    intent.putExtra("zona", seleccionado);
                    intent.putExtra("provincia", spLocalidades.getSelectedItem().toString());
                    startActivity(intent);
                }
            }

        }
    }

    public static ArrayList<Localidad> getArrayListLocalidades() {
        return arrayListLocalidades;
    }

    public static void setArrayListLocalidades(ArrayList<Localidad> arrayListLocalidades) {
        Localidades.arrayListLocalidades = arrayListLocalidades;
    }
}