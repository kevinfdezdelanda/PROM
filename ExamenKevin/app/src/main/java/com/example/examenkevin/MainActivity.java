package com.example.examenkevin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener {

    private Button act1, act2, salir;
    private boolean sesionIniciada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sesionIniciada = false;
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            sesionIniciada = extras.getBoolean("sesionIniciada");
        }

        mostrarLogin();

        setContentView(R.layout.activity_main);

        act1 = (Button) findViewById(R.id.act1);
        act2 = (Button) findViewById(R.id.act2);
        salir = (Button) findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                DialogoInformacion dialogoInfo = new DialogoInformacion("Hasta pronto!", true);
                dialogoInfo.show(fragmentManager,"tagAlerta");
            }
        });

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
        if(usu.equals("usuario") && pass.equals("123456")){
            Toast.makeText(this, "Login correcto",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login incorrecto",
                    Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager= getSupportFragmentManager();
            DialogoAlerta dialogoAlerta = new DialogoAlerta("Usuario y/o Contraseña incorrecos. La aplicacion se cerrara");
            dialogoAlerta.show(fragmentManager,"tagAlerta");
        }
    }
    @Override
    public void onNegativeButtonClick() {

        FragmentManager fragmentManager= getSupportFragmentManager();
        DialogoAlerta dialogoAlerta = new DialogoAlerta("Usuario y password necesarios para entrar en la aplicacion");
        dialogoAlerta.show(fragmentManager,"tagAlerta");

    }

    public void cambiarActividad(View v){
        if(v.equals(act1)){
            Intent intent = new Intent(MainActivity.this, PerfilCandidato.class);
            startActivity(intent);
        }

        if(v.equals(act2)){
            Intent intent = new Intent(MainActivity.this, Localidades.class);
            startActivity(intent);
        }
    }
}