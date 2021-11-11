package com.example.ej_ud02_dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager= getSupportFragmentManager();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fragmentManager,"tagAlerta");

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPossitiveButtonClick(String usu, String pass) {
        if(usu.equals("usuario1") && pass.equals("123456")){
            Toast.makeText(this, "Login correcto",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login incorrecto",
                    Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this, "Botón Negativo pulsado",
                Toast.LENGTH_SHORT).show();
    }
}