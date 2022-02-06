package com.example.ejxml;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Ej2 extends AppCompatActivity {

    public String url = "https://www.aemet.es/xml/municipios/localidad_01059.xml";
    private ListView listClima;
    private List<Clima> climas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej2);

        listClima = (ListView)findViewById(R.id.listClima);

        cargarXMLConSAX();



    }

    //Con la propiedad onClick en los botones
    public void cargarXMLConSAX (){
        Ej2.CargarXmlTask tarea = new Ej2.CargarXmlTask();
        tarea.execute(url);
    }

    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserDOM dom = new RssParserDOM(url);
            climas = dom.parse();

            return true;
        }

        @SuppressLint("SetTextI18n")
        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los títulos en pantalla
            if (climas != null) {
                for (int i = 0; i < climas.size(); i++) {
                    AdaptadorClima adaptadorClima =
                            new AdaptadorClima(Ej2.this, climas);
                    listClima.setAdapter(adaptadorClima);
                }
            }
        }
    }
}
