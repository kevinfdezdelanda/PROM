package com.example.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AdaptadorContactos extends ArrayAdapter<Contacto> {

    private Contacto[] contactos;

    public AdaptadorContactos(@NonNull Context context, Contacto[] contactos) {
        super(context, R.layout.list_contactos_layout, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_contactos_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre02);
        nombre.setText(contactos[position].getNombre());
        TextView estado = (TextView)item.findViewById(R.id.estado01);
        estado.setText(contactos[position].getEstado());
        ImageView img = (ImageView)item.findViewById(R.id.img02);
        img.setImageDrawable(contactos[position].getImagen().getDrawable());
        return (item);
    }
}
