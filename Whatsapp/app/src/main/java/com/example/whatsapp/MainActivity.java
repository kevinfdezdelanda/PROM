package com.example.whatsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.whatsapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ListView listChats, listLlamadas, listContactos;
    private Contacto[] contactosArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Asignamos al ViewPager el PageAdapter
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdaprter());
        // Se asigna al TabLayout el ViewPager y configura el modo de las pestañas
        TabLayout tabLayout= findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        ImageView usu1Img = new ImageView(this);
        usu1Img.setImageResource(R.drawable.usu1);

        ImageView usu2Img = new ImageView(this);
        usu2Img.setImageResource(R.drawable.usu2);

        ImageView usu3Img = new ImageView(this);
        usu3Img.setImageResource(R.drawable.usu3);

        ImageView usu4Img = new ImageView(this);
        usu4Img.setImageResource(R.drawable.usu4);

        ImageView usu5Img = new ImageView(this);
        usu5Img.setImageResource(R.drawable.usu5);

        contactosArray = new Contacto[] {
                new Contacto(usu1Img, "Carla", "Hola no me hables", "Ya he llegado", "Ayer", "07/06/2021",  1 ),
                new Contacto(usu2Img, "Maria", "...", "Si, tu?", "Hoy", "07/06/2021", 2 ),
                new Contacto(usu3Img, "Jose Antonio", "Nose que poner", "Holaaaaaaaa", "Hoy", "07/06/2021",  31 ),
                new Contacto(usu4Img, "Marcos", "asdasd", "KLK BRooooo", "Ayer", "07/06/2021",  2 ),
                new Contacto(usu5Img, "Juanito Juan", "pagame", "pagame lo que me debes moroso ultimo aviso", "Hoy", "07/06/2021",  9 ),
        };
    }

    public void insertatListaChats(Contacto[] contactos){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class PageAdaprter extends PagerAdapter {
        private LinearLayout chats;
        private LinearLayout contactos;
        private LinearLayout llamadas;
        private final int[] pestanas = {R.string.tab1, R.string.tab2, R.string.tab3};
        @Override
        public int getCount() {
            return 3;
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String s = getString(pestanas[position]);
            return s;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch (position){
                case 0:
                    if (chats == null){
                        chats = (LinearLayout)
                            LayoutInflater.from(MainActivity.this).inflate(R.layout.chats, container,false );
                    }
                    page = chats;
                    listChats = (ListView) chats.findViewById(R.id.listChats);

                    AdaptadorChats adaptadorChats =
                            new AdaptadorChats(chats.getContext(), contactosArray);
                    listChats.setAdapter(adaptadorChats);
                    break;
                case 1:
                    if (contactos == null) {
                        contactos = (LinearLayout)
                                LayoutInflater.from(MainActivity.this)
                                        .inflate(R.layout.contactos,container,false);
                    }
                    page=contactos;
                    break;
                default:
                    if (llamadas == null) {
                        llamadas = (LinearLayout)
                                LayoutInflater.from(MainActivity.this)
                                        .inflate(R.layout.llamadas,container,false);
                    }
                    page=llamadas;
                    listLlamadas = (ListView) llamadas.findViewById(R.id.listLlamadas);

                    AdaptadorLLamadas adaptadorLLamadas =
                            new AdaptadorLLamadas(llamadas.getContext(), contactosArray);
                    listLlamadas.setAdapter(adaptadorLLamadas);
                    break;
            }
            container.addView(page, 0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view,
                                        @NonNull Object object) {
            //return false;
            return view == object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}