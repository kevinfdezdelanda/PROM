package com.example.examen2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class CrearGuardarCli extends AppCompatActivity {

    private EditText txtDni, txtNombre, txtDireccion, txtTelf;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_guardarcli);

        txtDni = findViewById(R.id.txtDni);
        txtNombre = findViewById(R.id.txtNombre);
        txtDireccion = findViewById(R.id.txtDirec);
        txtTelf = findViewById(R.id.txtTelf);

        guardar = findViewById(R.id.btnGuardarCli);

        Cliente cliente = null;
        if(getIntent().getExtras()!=null){
            cliente = (Cliente) getIntent().getSerializableExtra("cliente");
            txtDni.setText(cliente.getDni()+"");
            txtNombre.setText(cliente.getNombre());
            txtDireccion.setText(cliente.getDireccion());
            txtTelf.setText(cliente.getTfno());

            txtDni.setEnabled(false);
            txtNombre.setEnabled(false);

        }

        Cliente finalCliente = cliente;
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strDni = txtDni.getText().toString();
                String nombre = txtNombre.getText().toString();
                String direccion = txtDireccion.getText().toString();
                String telf = txtTelf.getText().toString();

                if(strDni.equals("")||nombre.equals("")||direccion.equals("")||telf.equals("")){
                    FragmentManager fragmentManager= getSupportFragmentManager();
                    DialogoAlerta dialogoAlerta = new DialogoAlerta(getString(R.string.alerta1));
                    dialogoAlerta.show(fragmentManager,"tagAlerta");
                }else{
                    ClientesSQLiteHelper usdbh =
                            new ClientesSQLiteHelper(CrearGuardarCli.this, "DBClientes2", null, 1);

                    SQLiteDatabase db = usdbh.getWritableDatabase();
                    if(finalCliente != null){
                        //Establecemos los campos-valores a actualizar
                        ContentValues valores = new ContentValues();
                        valores.put("direccion", direccion);
                        valores.put("tfno", telf);
                        //Actualizamos el registro en la base de datos
                        db.update("Clientes", valores, "dni="+finalCliente.getDni() , null);
                    }else{
                        ContentValues nuevoRegistro = new ContentValues();
                        nuevoRegistro.put("dni", Integer.parseInt(strDni));
                        nuevoRegistro.put("nombre", nombre);
                        nuevoRegistro.put("direccion", direccion);
                        nuevoRegistro.put("tfno", telf);
                        //Insertamos el registro en la base de datos
                        db.insert("Clientes", null, nuevoRegistro);
                    }

                    Intent intent = new Intent(CrearGuardarCli.this, Ej1_1.class);
                    startActivity(intent);
                }

            }
        });
    }
}
