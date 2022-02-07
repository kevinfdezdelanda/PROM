package com.example.examen2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Ej1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1_1);

        Spinner spinner = (Spinner) findViewById(R.id.spCli);

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

        Button crearCli = findViewById(R.id.btnCrearCli);
        crearCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ej1_1.this, CrearGuardarCli.class);
                startActivity(intent);
            }
        });

        Button modificarCli = findViewById(R.id.btnModificarCli);
        modificarCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = (Cliente) spinner.getSelectedItem();
                System.out.println(cliente);
                Intent intent = new Intent(Ej1_1.this, CrearGuardarCli.class).putExtra("cliente",cliente);
                startActivity(intent);
            }
        });
    }
}