package com.example.xml;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Ej1 extends AppCompatActivity {

    public String url = "https://www.europapress.es/rss/rss.aspx";
    private ListView listNoticias;
    private List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1);

        listNoticias = (ListView)findViewById(R.id.listNoticias);
        cargarXMLConSAX();


        listNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Noticia noticia = ((Noticia)adapterView.getItemAtPosition(i));

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(noticia.getLink()+""));
                startActivity(intent);
            }
        });
    }

    //Con la propiedad onClick en los botones
    public void cargarXMLConSAX (){
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSAX saxparser = new RssParserSAX(params[0]);
            noticias = saxparser.parse();

            return true;
        }

        @SuppressLint("SetTextI18n")
        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los títulos en pantalla
            if (noticias != null) {
                for (int i = 0; i < noticias.size(); i++) {
                    AdaptadorNoticias adaptadorNoticias =
                            new AdaptadorNoticias(Ej1.this, noticias);
                    listNoticias.setAdapter(adaptadorNoticias);
                }
            }
        }
    }

}

