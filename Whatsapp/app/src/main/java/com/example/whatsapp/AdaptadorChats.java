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

class AdaptadorChats extends ArrayAdapter<Contacto> {

    private Contacto[] contactos;

    public AdaptadorChats(@NonNull Context context, Contacto[] contactos) {
        super(context, R.layout.list_chats_layout, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_chats_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre02);
        nombre.setText(contactos[position].getNombre());
        TextView ultMsg = (TextView)item.findViewById(R.id.estado01);
        ultMsg.setText(contactos[position].getUltMsg());
        TextView fechaMsg = (TextView)item.findViewById(R.id.fechaMsg);
        fechaMsg.setText(contactos[position].getFechaMsg());
        TextView numMsg = (TextView)item.findViewById(R.id.numMsg);
        numMsg.setText(contactos[position].getNumMsg()+"");
        ImageView img = (ImageView)item.findViewById(R.id.img02);
        img.setImageDrawable(contactos[position].getImagen().getDrawable());
        return (item);
    }
}
