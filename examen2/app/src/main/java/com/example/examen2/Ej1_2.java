package com.example.examen2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class Ej1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1_2);

        Spinner spinner = (Spinner) findViewById(R.id.spCli2);

        // Spinner Drop down elements
        List<Cliente> clientes = new ArrayList<>();

        //Abrimos la base de datos "DBUsuarios" en modo de escritura
        ClientesSQLiteHelper usdbh =
                new ClientesSQLiteHelper(this, "DBClientes2", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Clientes ",null );

        //Recorremos los resultados para mostrarlos en pantalla
        //Nos aseguramos de que existe al menos un registro
        Cliente cli = null;
        if (c.moveToFirst()){
            //Recorremos el cursor hasta que no haya más registros.
            do {
                int dni = c.getInt(0);
                String nombre =c.getString(1);
                String direccion = c.getString(2);
                String telf = c.getString(2);

                cli = new Cliente(dni,nombre,direccion,telf);
                clientes.add(cli);
            }while (c.moveToNext());
        }

        // Creating adapter for spinner
        ArrayAdapter<Cliente> dataAdapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_spinner_item, clientes);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Button crearFac = findViewById(R.id.btnCrearFac);
        TextView txtConcepto = findViewById(R.id.txtConcepto);
        TextView txtValor = findViewById(R.id.txtValor);

        crearFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concepto = txtConcepto.getText().toString();
                String strValor = txtValor.getText().toString();
                Cliente cliente = (Cliente) spinner.getSelectedItem();
                if(concepto.equals("")||strValor.equals("")||cliente==null){
                    FragmentManager fragmentManager= getSupportFragmentManager();
                    DialogoAlerta dialogoAlerta = new DialogoAlerta(getString(R.string.alerta1));
                    dialogoAlerta.show(fragmentManager,"tagAlerta");
                }else{
                    Cursor c = db.rawQuery("SELECT max(Num) FROM Facturas",null );

                    //Recorremos los resultados para mostrarlos en pantalla
                    //Nos aseguramos de que existe al menos un registro
                    int num = 1;
                    if (c.moveToFirst()){
                        num = c.getInt(0)+1;
                    }

                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("Num", num);
                    nuevoRegistro.put("dni", cliente.getDni());
                    nuevoRegistro.put("Concepto", concepto);
                    nuevoRegistro.put("Valor", Double.parseDouble(strValor));
                    //Insertamos el registro en la base de datos
                    if(db.insert("Facturas", null, nuevoRegistro)==-1){
                        FragmentManager fragmentManager= getSupportFragmentManager();
                        DialogoAlerta dialogoAlerta = new DialogoAlerta(getString(R.string.alerta2));
                        dialogoAlerta.show(fragmentManager,"tagAlerta");
                    }else{
                        FragmentManager fragmentManager= getSupportFragmentManager();
                        DialogoAlerta dialogoAlerta = new DialogoAlerta(getString(R.string.alerta3));
                        dialogoAlerta.show(fragmentManager,"tagAlerta");
                    }

                    txtConcepto.setText("");
                    txtValor.setText("");
                    spinner.setSelection(0);
                }
            }
        });
    }
}