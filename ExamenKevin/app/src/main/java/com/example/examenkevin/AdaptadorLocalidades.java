package com.example.examenkevin;

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

class AdaptadorLocalidades extends ArrayAdapter<Localidad> {

    private ArrayList<Localidad> localidades;

    public AdaptadorLocalidades(@NonNull Context context, ArrayList<Localidad> localidades) {
        super(context, R.layout.localidades_layout, localidades);
        this.localidades = localidades;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.localidades_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(localidades.get(position).getCiudad());
        ImageView img = (ImageView)item.findViewById(R.id.img04);
        img.setImageDrawable(localidades.get(position).getImg());
        return (item);
    }
}