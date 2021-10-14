package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej03_2 extends AppCompatActivity {

    private Button volver;
    private TextView nombre2, apellido2, sexo2, aficiones2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej03_2);

        volver = (Button) findViewById(R.id.volver03);

        nombre2 = (TextView) findViewById(R.id.nombre2);
        apellido2 = (TextView) findViewById(R.id.apellido2);
        sexo2 = (TextView) findViewById(R.id.sexo2);
        aficiones2 = (TextView) findViewById(R.id.aficiones2);

        Bundle extras = getIntent().getExtras();
        nombre2.setText(extras.getString("nombre"));
        apellido2.setText(extras.getString("apellido"));
        sexo2.setText(extras.getString("sexo"));
        aficiones2.setText(extras.getString("aficiones"));
    }

    public void volver03(View v){
        Intent intent = new Intent(Ej03_2.this, Ej03.class);
        if(v.equals(volver)){
            startActivity(intent);
        }
    }

}
