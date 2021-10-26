package com.example.listas_e_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ej03 extends AppCompatActivity {

    private ListView listContactos;
    private ArrayList<Contacto> contactos;
    private Button nuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej03);

        listContactos = (ListView) findViewById(R.id.listContactos);
        nuevo = (Button) findViewById(R.id.nuevoCont);

        contactos = new ArrayList<>();
        contactos.add(new Contacto("Juan Carlos", "juancar@gmail.com", true));
        contactos.add(new Contacto("Juan Pablo", "juampa_rampa@gmail.com", true));
        contactos.add(new Contacto("Antonia", "673 78 78 78", false));
        contactos.add(new Contacto("Jose Juan", "jose_juan@jose_juan.jose_juan", true));

        AdaptadorContactos adaptadorContactos =
                new AdaptadorContactos(this, contactos);
        listContactos.setAdapter(adaptadorContactos);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String nombre = extras.getString("nombre");
            String correoTelf = extras.getString("correoTelf");
            boolean esCorreo = extras.getBoolean("esCorreo");

            Contacto c = new Contacto(nombre, correoTelf, esCorreo);
            contactos.add(c);
        }
    }

    public void nuevoContacto(View v){
        if (v.equals(nuevo)){

            Intent intent = new Intent(Ej03.this, Ej03_2.class);
            startActivity(intent);
        }
    }

    public void nuevoCont(View v){
        Intent intent = new Intent(Ej03.this, Ej03_2.class);
        intent.putExtra("contactos", contactos);
        startActivity(intent);
    }

}