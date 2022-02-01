package com.example.ficheros;

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

class AdaptadorWebs extends ArrayAdapter<Web> {

    private ArrayList<Web> webs;

    public AdaptadorWebs(@NonNull Context context, ArrayList<Web> webs) {
        super(context, R.layout.webs_layout, webs);
        this.webs = webs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.webs_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre2);
        nombre.setText(webs.get(position).getNombre());
        TextView url = (TextView)item.findViewById(R.id.contacto2);
        url.setText(webs.get(position).getUrl());
        TextView id = (TextView)item.findViewById(R.id.id);
        id.setText(webs.get(position).getId());
        ImageView img = (ImageView)item.findViewById(R.id.img04);
        img.setImageDrawable(webs.get(position).getImagen().getDrawable());
        System.out.println(webs.get(position).getImagen().getDrawable());
        return (item);
    }
}
