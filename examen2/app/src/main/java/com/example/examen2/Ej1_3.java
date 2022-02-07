package com.example.examen2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class Ej1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej1_3);

        Spinner spinner = (Spinner) findViewById(R.id.spCli3);

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

        ListView list = findViewById(R.id.listFacturas);

        Button btnVerFac = findViewById(R.id.btnVerFac);

        btnVerFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cliente cliente = (Cliente) spinner.getSelectedItem();
                if(cliente!=null) {
                    List<Factura> facturas = new ArrayList<>();

                    String[] args = new String[] {cliente.getDni()+""};
                    Cursor c = db.rawQuery("SELECT * FROM Facturas where dni=?",args );

                    //Recorremos los resultados para mostrarlos en pantalla
                    //Nos aseguramos de que existe al menos un registro
                    Factura f = null;
                    if (c.moveToFirst()){
                        //Recorremos el cursor hasta que no haya más registros.
                        do {
                            int num = c.getInt(0);
                            String concepto =c.getString(2);
                            Double valor = c.getDouble(3);

                            f = new Factura(num,concepto,valor,cliente);
                            facturas.add(f);
                        }while (c.moveToNext());
                    }

                    AdaptadorFacturas adaptadorFacturas =
                            new AdaptadorFacturas(Ej1_3.this, facturas);
                    list.setAdapter(adaptadorFacturas);

                    if(facturas.size()==0){
                        FragmentManager fragmentManager= getSupportFragmentManager();
                        DialogoAlerta dialogoAlerta = new DialogoAlerta("Sin Facturas");
                        dialogoAlerta.show(fragmentManager,"tagAlerta");
                    }
                }

            }
        });


    }
}