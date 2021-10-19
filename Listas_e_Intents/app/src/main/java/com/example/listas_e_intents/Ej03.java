package com.example.listas_e_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej03 extends AppCompatActivity {

    private ListView listContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej03);

        listContactos = (ListView) findViewById(R.id.listContactos);

        final Contacto[] contactos = new Contacto[] {
            new Contacto("Juan Carlos", "juancar@gmail.com", true),
            new Contacto("Juan Pablo", "juampa_rampa@gmail.com", true),
            new Contacto("Antonia", "673 78 78 78", false),
            new Contacto("Jose Juan", "jose_juan@jose_juan.jose_juan", true)
        };

        AdaptadorContactos adaptadorContactos =
                new AdaptadorContactos(this, contactos);
        listContactos.setAdapter(adaptadorContactos);


    }


}