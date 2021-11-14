package com.example.ej_ud02_dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener{

    private boolean sesionIniciada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sesionIniciada = false;
        mostrarLogin();

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    public void mostrarLogin(){
        if(!sesionIniciada){
            FragmentManager fragmentManager= getSupportFragmentManager();
            DialogoLogin dialogoLogin = new DialogoLogin();
            dialogoLogin.show(fragmentManager,"tagAlerta");
        }
    }

    @Override
    public void onPossitiveButtonClick(String usu, String pass) {
        if(usu.equals("usuario1") && pass.equals("123456")){
            Toast.makeText(this, "Login correcto",
                    Toast.LENGTH_SHORT).show();
            sesionIniciada = true;
        }else{
            Toast.makeText(this, "Login incorrecto",
                    Toast.LENGTH_SHORT).show();
            mostrarLogin();
            sesionIniciada = false;
        }

    }
    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this, "Botón Negativo pulsado",
                Toast.LENGTH_SHORT).show();
        cerrarAplicacion();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            cerrarAplicacion();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarLogin();
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        //finish(); Si solo quiere mandar la aplicación a segundo plano
                    }
                }).show();
    }
}