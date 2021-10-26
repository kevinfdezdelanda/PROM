package com.example.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.whatsapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class Prueba extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba);

        //Asignamos al ViewPager el PageAdapter
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdaprter());
        // Se asigna al TabLayout el ViewPager y configura el modo de las pestañas
        TabLayout tabLayout= findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);


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
                            LayoutInflater.from(Prueba.this).inflate(R.layout.chats, container,false );
                    }
                    page = chats;
                    break;
                case 1:
                    if (contactos == null) {
                        contactos = (LinearLayout)
                                LayoutInflater.from(Prueba.this)
                                        .inflate(R.layout.contactos,container,false);
                    }
                    page=contactos;
                    break;
                default:
                    if (llamadas == null) {
                        llamadas = (LinearLayout)
                                LayoutInflater.from(Prueba.this)
                                        .inflate(R.layout.llamadas,container,false);
                    }
                    page=llamadas;
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