package com.example.actividadfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class FragmentListado extends Fragment {

    private Pelicula[] datos = new Pelicula [] {
            new Pelicula ("Venom", "Sinopsis de la Pelicula 1", "Diretor", R.drawable.venom, 5),
            new Pelicula ("Venom", "Sinopsis de la Pelicula 1", "Diretor", R.drawable.venom, 5),
            new Pelicula ("Venom", "Sinopsis de la Pelicula 1", "Diretor", R.drawable.venom, 5),
            new Pelicula ("Venom", "Sinopsis de la Pelicula 1", "Diretor", R.drawable.venom, 5),
            new Pelicula ("Venom", "Sinopsis de la Pelicula 1", "Diretor", R.drawable.venom, 5)};

    private ListView lstListado;

    private PeliculaListener listener;

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
        lstListado.setAdapter(new AdaptadorPeliculas(this));
        //Asignamos el evento onItemClick() a la lista de los Peliculas
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onPeliculaSeleccionado(
                            (Pelicula)lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorPeliculas extends ArrayAdapter<Pelicula> {
        Activity context;
        AdaptadorPeliculas(Fragment context) {
            super(context.getActivity(), R.layout.listitem_pelicula, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_pelicula, null);
            TextView titulo = (TextView) item.findViewById(R.id.titulo);
            titulo.setText(datos[position].getTitulo());
            TextView director = (TextView)item.findViewById(R.id.director);
            director.setText(datos[position].getDirector());
            TextView nota = (TextView)item.findViewById(R.id.puntuacion);
            nota.setText(datos[position].getNota()+"");
            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setImageResource(datos[position].getImagen());
            return (item);
        }
    }

    // public interface PeliculaListener {
    // void onPeliculaSeleccionado(Pelicula c);
    // }
    public void setPeliculaListener (PeliculaListener listener){
        this.listener = listener;
    }
}