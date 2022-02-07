package com.example.examen2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientesSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreateClientes =
            "CREATE TABLE Clientes (dni INTEGER PRIMARY KEY," +
                    " nombre TEXT, direccion TEXT, tfno TEXT)";
    String sqlCreateFacturas =
            "CREATE TABLE Facturas (Num INTEGER PRIMARY KEY," +
                    " dni INTEGER, Concepto TEXT, Valor REAL)";

    public ClientesSQLiteHelper(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreateFacturas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
     /*NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
     la opción de eliminar la tabla anterior y crearla de nuevo vacia
     con el nuevo formato.
     Sin embargo lo normal será que haya que migrar datos de la
     tabla antigua a la nueva, por lo que este método deberia
     ser más elaborado.
     */
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL("DROP TABLE IF EXISTS Facturas");
        //Se crea la nueva version de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreateFacturas);
    }

    public void crearCliente(Cliente c){
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("dni", c.getDni());
        nuevoRegistro.put("nombre", c.getNombre());
        nuevoRegistro.put("direccion", c.getDireccion());
        nuevoRegistro.put("tfno", c.getTfno());
        //Insertamos el registro en la base de datos
        //db.insert("Usuarios", null, nuevoRegistro);
    }
}
