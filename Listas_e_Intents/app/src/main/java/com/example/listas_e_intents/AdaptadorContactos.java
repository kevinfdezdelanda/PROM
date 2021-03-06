package com.example.listas_e_intents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class AdaptadorContactos extends ArrayAdapter<Contacto> {

    private ArrayList<Contacto> contactos;

    public AdaptadorContactos(@NonNull Context context, ArrayList<Contacto> contactos) {
        super(context, R.layout.contactos_layout, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.contactos_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(contactos.get(position).getNombre());
        TextView contacto = (TextView)item.findViewById(R.id.contacto);
        contacto.setText(contactos.get(position).getCorreo_telf());

        ImageView img = (ImageView)item.findViewById(R.id.img03);
        if(contactos.get(position).isEsCorreo()){
            img.setImageResource(R.drawable.correo);
        }else{
            img.setImageResource(R.drawable.telefono);
        }

        return (item);
    }
}
