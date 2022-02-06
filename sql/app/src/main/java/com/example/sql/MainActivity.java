package com.example.sql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Abrimos la base de datos "DBUsuarios" en modo de escritura
        UsuariosSQLiteHelper usdbh =
                new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        usdbh.onUpgrade(db, 1,1);

        //Si hemos abierto correctamente la base de datos
        if (db != null){
            //Insertamoa 5 usuarios de ejemplo
            for (int i =1; i<=5; i++){
                //Generamos los datos
                int codigo = i;
                String nombre ="Usuario "+i;
                String email = "usuario"+i+"@usuarios.com";
                //Insertamos los datos en la tabla de Usuarios
                db.execSQL("INSERT INTO Usuarios (idUsuario, nombre, email)" +
                        " VALUES ("+ codigo +" ,'"+ nombre +"','"+email+"')");
            }
            //Cerramos la base de datos
            db.close();
        }
    }
}
