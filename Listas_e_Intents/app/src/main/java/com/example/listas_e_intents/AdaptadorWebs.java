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

class AdaptadorWebs extends ArrayAdapter<Web> {

    private Web[] webs;

    public AdaptadorWebs(@NonNull Context context, Web[] webs) {
        super(context, R.layout.webs_layout, webs);
        this.webs = webs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.webs_layout, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(webs[position].getNombre());
        TextView url = (TextView)item.findViewById(R.id.url);
        url.setText(webs[position].getUrl());
        TextView id = (TextView)item.findViewById(R.id.id);
        id.setText(webs[position].getId());
        ImageView img = (ImageView)item.findViewById(R.id.img);
        img.setImageDrawable(webs[position].getImagen().getDrawable());
        return (item);
    }
}
