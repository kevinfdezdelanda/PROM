package com.example.ej_ud02_dialogos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {

    private Kebab[] datos = new Kebab [] {
            new Kebab ("PanPita", "Carner, ensalada, salsa, pan pita", R.drawable.pan_pita),
            new Kebab ("Durum", "Carner, ensalada, salsa, wrap", R.drawable.durum),
            new Kebab ("Plato Carne", "carne, salsa, ensalada", R.drawable.plato_carne),
            new Kebab ("Patatas", "patatas, salsa", R.drawable.patatas)};

    private ListView lstListado;

    private KebabsListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView)getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorKebabs(this));
        //Asignamos el evento onItemClick() a la lista de los Peliculas
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onKebabSeleccionado(
                            (Kebab)lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorKebabs extends ArrayAdapter<Kebab> {
        Activity context;
        AdaptadorKebabs(Fragment context) {
            super(context.getActivity(), R.layout.listitem_kebab, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_kebab, null);
            TextView nombreKebab = (TextView) item.findViewById(R.id.nombreKebab);
            nombreKebab.setText(datos[position].getNombre());
            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setImageResource(datos[position].getImg());
            return (item);
        }
    }

    // public interface PeliculaListener {
    // void onPeliculaSeleccionado(Pelicula c);
    // }
    public void setKebabListener (KebabsListener listener){
        this.listener = listener;
    }
}