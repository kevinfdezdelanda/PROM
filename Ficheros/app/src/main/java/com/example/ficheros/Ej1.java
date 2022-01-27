package com.example.ficheros;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ej1 extends AppCompatActivity {

    private Button btnFichInt, btnFichExt, btnLeerFichInt, btnLeerFichExt, btnLeerRecurso, btnBorrarFichInt, btnBorrarFichExt;
    private TextView contenido, contFichero;

    private static final int SOLICITUD_PERMISO_WRITE_SD = 0;
    private static final int SOLICITUD_PERMISO_READ_SD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1);

        btnFichInt = findViewById(R.id.btnFichInt);
        btnFichExt = findViewById(R.id.btnFichExt);
        btnLeerFichInt = findViewById(R.id.btnLeerFichInt);
        btnLeerFichExt = findViewById(R.id.btnLeerFichExt);
        btnLeerRecurso = findViewById(R.id.btnLeerRecurso);
        btnBorrarFichInt = findViewById(R.id.btnBorrarFichInt2);
        btnBorrarFichExt = findViewById(R.id.btnBorrarFichExt);

        contenido = findViewById(R.id.contenido);
        contFichero = findViewById(R.id.contFichero);

        btnFichInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!contenido.getText().equals("")) {
                        OutputStreamWriter osw =
                                new OutputStreamWriter(openFileOutput("fich.txt",
                                        Context.MODE_PRIVATE));
                        osw.write(contenido.getText() + "");
                        osw.close();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnFichExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (comprobarPermisos()) {
                        Toast.makeText(Ej1.this,
                                "Tenemos permisos para escribir",
                                Toast.LENGTH_SHORT).show();
                        if (sdDisponible()) {
                            escribirEnSD(contenido.getText() + "");
                        } else
                            Toast.makeText(Ej1.this,
                                    "Tarjeta NO lista para poder escribir",
                                    Toast.LENGTH_SHORT).show();
                    } else {
                        solicitarPermiso(
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                "Sin este permiso no se puede ESCRIBIR en el dispositivo externo",
                                SOLICITUD_PERMISO_WRITE_SD, Ej1.this);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnLeerFichInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("fich.txt")));
                    String texto = fin.readLine();
                    fin.close();
                    contFichero.setText(texto);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnLeerFichExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobarPermisos()){
                    Toast.makeText(Ej1.this,
                            "Tenemos permisos para leer",
                            Toast.LENGTH_SHORT).show();
                    if (sdDisponible()) {
                        leerDeSD();
                    }
                    else
                        Toast.makeText(Ej1.this,
                                "Tarjeta NO lista para poder leer",
                                Toast.LENGTH_SHORT).show();
                }
                else {
                    solicitarPermiso(
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            "Sin este permiso no se puede LEER en el dispositivo externo",
                            SOLICITUD_PERMISO_WRITE_SD, Ej1.this);
                }
            }
        });

        btnLeerRecurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream fraw = getResources().openRawResource(R.raw.recurso);
                    BufferedReader brin = new BufferedReader( new InputStreamReader(fraw));
                    String linea= brin.readLine();
                    String texto = "";
                    while (linea!=null){
                        Log.i("Ficheros", linea);
                        texto += linea;
                        linea=brin.readLine();
                    }
                    contFichero.setText(texto);
                    fraw.close();
                }catch (Exception ex) {
                    Log.e ("Ficheros", "Error al leer fichero desde recurso raw");
                }
            }
        });

        btnBorrarFichInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File dir = getFilesDir();
                    File file = new File(dir, "fich.txt");
                    boolean deleted = file.delete();
                    if(deleted){
                        Toast.makeText(Ej1.this,
                                "Archivo borrado",
                                Toast.LENGTH_SHORT).show();
                        contFichero.setText("");
                    }else{
                        Toast.makeText(Ej1.this,
                                "Archivo no borrado",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnBorrarFichExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File ruta_sd = Environment.getExternalStorageDirectory();
                File f = new File(ruta_sd.getAbsolutePath(), "sd.txt");
                boolean deleted = f.delete();
                if(deleted){
                    Toast.makeText(Ej1.this,
                            "Archivo borrado",
                            Toast.LENGTH_SHORT).show();
                    contFichero.setText("");
                }else{
                    Toast.makeText(Ej1.this,
                            "Archivo no borrado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private boolean comprobarPermisos() {
        //Comprobamos que tenemos permiso para realizar la operación.
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private boolean sdDisponible() {
        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;
        //Comprobamos el estado de la memoria externa
        String estado = Environment.getExternalStorageState();
        Log.i("Memoria", estado);
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
        if (sdDisponible)
            Toast.makeText(getApplicationContext(),
                    "Tengo Tarjeta SD",
                    Toast.LENGTH_SHORT).show();
        if (sdAccesoEscritura)
            Toast.makeText(getApplicationContext(),
                    "La tarjeta SD es escribible",
                    Toast.LENGTH_SHORT).show();
        if (sdDisponible && sdAccesoEscritura)
            return true;
        else
            return false;
    }

    private void escribirEnSD(String texto) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "sd.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write(texto);
            osw.close();
            Log.i("Ficheros", "fichero escrito correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    private void leerDeSD() {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "sd.txt");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea + "\n";
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
            contFichero.setText(texto);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }

    private static void solicitarPermiso(final String permiso,
                                         String justificacion,
                                         final int requestCode,
                                         final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                actividad, permiso)) {
            //Informamos al usuario para qué y por qué
            //se necesitan los permisos
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    ActivityCompat.requestPermissions(actividad,
                                            new String[]{permiso}, requestCode);
                                }
                            }).show();
        } else {
            //Muestra el cuadro de dialogo para la solicitud de permisos y
            //registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SOLICITUD_PERMISO_WRITE_SD) {
            if (grantResults.length >= 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e("AAAA", "Escribir Memoria SD");
                sdDisponible();
                escribirEnSD(contenido.getText() + "");
            } else {
                Toast.makeText(this,
                        "No se puede ESCRIBIR en memoria SD",
                        Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == SOLICITUD_PERMISO_READ_SD) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                leerDeSD();
            } else {
                Toast.makeText(this,
                        "No se puede LEER de memoria SD",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}