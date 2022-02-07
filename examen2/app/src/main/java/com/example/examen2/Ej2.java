package com.example.examen2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Locale;

public class Ej2 extends AppCompatActivity {

    private Button btnBilbao, btnGasteiz, btnDonostia;
    private ConstraintLayout layoutDatos;
    private TextView txtLocalidad, txtFechaHora, txtTemperatura, txtEstadoCielo;
    private ImageView imgCielo;

    private ArrayList<Integer> imagenes;

    private Clima clima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej2);

        btnBilbao = findViewById(R.id.btnBilbao);
        btnGasteiz = findViewById(R.id.btnGasteiz);
        btnDonostia = findViewById(R.id.btnDonostia);

        layoutDatos = findViewById(R.id.layoutDatos);
        layoutDatos.setVisibility(View.INVISIBLE);

        txtLocalidad = findViewById(R.id.txtLocalidad);
        txtFechaHora = findViewById(R.id.txtFechaHora);
        txtTemperatura = findViewById(R.id.txtTemperatura);
        txtEstadoCielo = findViewById(R.id.txtEstadoCielo);

        imgCielo = findViewById(R.id.imgCielo);

        btnBilbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutDatos.setVisibility(View.VISIBLE);
                cargarXMLConSAX("https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050");
                txtLocalidad.setText(btnBilbao.getText().toString().toUpperCase(Locale.ROOT));
            }
        });

        btnGasteiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutDatos.setVisibility(View.VISIBLE);
                cargarXMLConSAX("https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8043");
                txtLocalidad.setText(btnGasteiz.getText().toString().toUpperCase(Locale.ROOT));
            }
        });

        btnDonostia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutDatos.setVisibility(View.VISIBLE);
                cargarXMLConSAX("https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917");
                txtLocalidad.setText(btnDonostia.getText().toString().toUpperCase(Locale.ROOT));
            }
        });
    }

    //Con la propiedad onClick en los botones
    public void cargarXMLConSAX (String url){
        Ej2.CargarXmlTask tarea = new Ej2.CargarXmlTask(url);
        tarea.execute(url);
    }

    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {
        private String url;

        public CargarXmlTask(String url){
            this.url = url;
        }

        protected Boolean doInBackground(String... params) {
            RssParserDOM dom = new RssParserDOM(url);
            clima = dom.parse();

            return true;
        }

        @SuppressLint("SetTextI18n")
        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los títulos en pantalla
            if (clima != null) {
                //Relleno los datos
                txtFechaHora.setText(clima.getFecha()+" / "+clima.getHora());
                txtTemperatura.setText(clima.getTemp()+" ( Min: "+clima.getTemMin()+" / Max: "+clima.getTempMax()+" )");
                txtEstadoCielo.setText(clima.getEstadoCielo());

                Resources res = getResources();
                int resID = res.getIdentifier("i"+clima.getIcono(), "drawable", getPackageName());
                imgCielo.setImageResource(resID);
            }
        }
    }
}