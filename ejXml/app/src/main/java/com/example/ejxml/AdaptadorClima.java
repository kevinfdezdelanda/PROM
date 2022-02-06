package com.example.ejxml;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class AdaptadorClima extends ArrayAdapter<Clima> {

    private List<Clima> climas;

    public AdaptadorClima(@NonNull Ej2 context, List<Clima> Climas) {
        super(context, R.layout.clima_layout, Climas);
        this.climas = Climas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.clima_layout, null);
        TextView fecha = (TextView)item.findViewById(R.id.fecha);
        fecha.setText(climas.get(position).getFecha());
        TextView temMax = (TextView)item.findViewById(R.id.tempMax);
        temMax.setText(climas.get(position).getTempMax()+"Cº");
        TextView temMin = (TextView)item.findViewById(R.id.tempMin);
        temMin.setText(climas.get(position).getTemMin()+"Cº");
        return (item);
    }
}
