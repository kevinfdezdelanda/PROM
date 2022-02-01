package com.example.ficheros;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EJ3 extends AppCompatActivity {

    private ListView listWebs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej3);


        listWebs = (ListView) findViewById(R.id.listWebs);

        ArrayList<Web> webs = new ArrayList<>();

        try {
            InputStream fraw = getResources().openRawResource(R.raw.webs);
            BufferedReader brin = new BufferedReader( new InputStreamReader(fraw));
            String linea= brin.readLine();
            while (linea!=null){
                String[] partes = linea.split("; ");

                int resLogoWebID = EJ3.getResID(partes[2], R.drawable.class);
                ImageView imgWeb = new ImageView(this);
                if(resLogoWebID != -1)
                    imgWeb.setImageResource(resLogoWebID);

                System.out.println(getFileStreamPath(partes[2]+".jpg").getAbsolutePath());
                System.out.println(imgWeb.getDrawable());
                webs.add(new Web(partes[0], partes[1], partes[3], imgWeb));
                linea=brin.readLine();
            }
            fraw.close();
        }catch (Exception ex) {
            Log.e ("Ficheros", "Error al leer fichero desde recurso raw");
        }

        AdaptadorWebs adaptadorWebs =
                new AdaptadorWebs(this, webs);
        listWebs.setAdapter(adaptadorWebs);
    }

    private static int getResID(String resName, Class<?> c){
        try
        {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        }
        catch (Exception e)
        {
            return -1;
        }
    }

}