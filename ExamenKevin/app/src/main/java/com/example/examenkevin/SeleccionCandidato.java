package com.example.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionCandidato extends AppCompatActivity {

    private TextView txtNombre, txtFecha, txtSexo, txtProvincia, txtConocimientos;
    private Button aceptar, rechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.seleccion_candidato);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtProvincia = (TextView) findViewById(R.id.txtProvincia);
        txtConocimientos = (TextView) findViewById(R.id.txtConocimientos);

        aceptar = (Button) findViewById(R.id.aceptar);
        rechazar = (Button) findViewById(R.id.rechazar);

        Bundle extras = getIntent().getExtras();
        txtNombre.setText(extras.getString("nombre"));
        txtSexo.setText(extras.getString("sexo"));
        txtProvincia.setText(extras.getString("provincia"));
        txtConocimientos.setText(extras.getString("conocimientos"));
        txtFecha.setText(extras.getString("fecha"));
    }

    public void aceptarRechazar(View v){

        Intent intent = new Intent(SeleccionCandidato.this, PerfilCandidato.class);

        if(v.equals(aceptar)){
            setResult(RESULT_OK, intent);
            finish();
        }

        if(v.equals(rechazar)){
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

}