package com.example.examen2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class AdaptadorFacturas extends ArrayAdapter<Factura> {

    private List<Factura> facturas;

    public AdaptadorFacturas(@NonNull Ej1_3 context, List<Factura> Facturas) {
        super(context, R.layout.facturas_layout, Facturas);
        this.facturas = Facturas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.facturas_layout, null);
        TextView numFac = (TextView)item.findViewById(R.id.txtNumFac);
        numFac.setText(facturas.get(position).getNum()+"");
        TextView cli = (TextView)item.findViewById(R.id.txtCli);
        cli.setText(facturas.get(position).getC()+"");
        TextView concepto = (TextView)item.findViewById(R.id.txtConc);
        concepto.setText(facturas.get(position).getConcepto()+"");
        TextView valor = (TextView)item.findViewById(R.id.txtVal);
        valor.setText(facturas.get(position).getValor()+"€");
        return (item);
    }
}
