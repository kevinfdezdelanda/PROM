package com.example.xml;

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
import java.util.List;

class AdaptadorNoticias extends ArrayAdapter<Noticia> {

    private List<Noticia> Noticias;

    public AdaptadorNoticias(@NonNull Ej1 context, List<Noticia> noticias) {
        super(context, R.layout.noticias_layout, noticias);
        this.Noticias = noticias;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.noticias_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.titulo);
        nombre.setText(Noticias.get(position).getTitulo());
        TextView descripcion = (TextView)item.findViewById(R.id.descripcion);
        descripcion.setText(Noticias.get(position).getDescripcion());
        return (item);
    }
}
