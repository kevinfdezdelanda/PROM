package com.example.ej_ud02_dialogos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener, KebabsListener {

    private boolean sesionIniciada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sesionIniciada = false;
        mostrarLogin();

        setContentView(R.layout.activity_main);

        FragmentListado fragmentListado =
                (FragmentListado) getSupportFragmentManager().
                        findFragmentById(R.id.frgListado);
        //fragmentListado.setKebabListener(this);

        //Asignamos al ViewPager el PageAdapter
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdaprter());
        // Se asigna al TabLayout el ViewPager y configura el modo de las pestañas
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onKebabSeleccionado(Kebab k) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle) != null);
        if (hayDetalle) {
            ((FragmentDetalle) getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarDetalle(k.getIngredientes());
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, k.getIngredientes());
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    public void mostrarLogin() {
        if (!sesionIniciada) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoLogin dialogoLogin = new DialogoLogin();
            dialogoLogin.show(fragmentManager, "tagAlerta");
        }
    }

    @Override
    public void onPossitiveButtonClick(String usu, String pass) {
        if(usu.equals("usuario1") && pass.equals("123456")){
            Toast.makeText(this, "Login correcto",
                    Toast.LENGTH_SHORT).show();
            sesionIniciada = true;
        }else {
            Toast.makeText(this, "Login incorrecto",
                    Toast.LENGTH_SHORT).show();
            mostrarLogin();
            sesionIniciada = false;
        }

    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this, "Botón Negativo pulsado",
                Toast.LENGTH_SHORT).show();
        cerrarAplicacion();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            cerrarAplicacion();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarLogin();
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        //finish(); Si solo quiere mandar la aplicación a segundo plano
                    }
                }).show();
    }

    public void pedir(View v){
        Intent intent = new Intent(MainActivity.this, PedirKebab.class);
        startActivity(intent);
    }

    class PageAdaprter extends PagerAdapter {
        private LinearLayout menu;
        private ConstraintLayout pedido;

        private final int[] pestanas = {R.string.tab1, R.string.tab2};

        @Override
        public int getCount() {
            return 2;
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
            switch (position) {

                case 1:
                    if (pedido == null) {
                        PedirKebab pedirKebab = new PedirKebab();
                        pedido = (ConstraintLayout)
                                LayoutInflater.from(MainActivity.this)
                                        .inflate(R.layout.pedido, container, false);

                    }
                    page = pedido;

                    break;

                default:
                    if (menu == null) {

                        menu = (LinearLayout)
                                LayoutInflater.from(MainActivity.this)
                                        .inflate(R.layout.menu, container, false);

                        FragmentListado fragmentListado =
                                (FragmentListado)getSupportFragmentManager().
                                        findFragmentById(R.id.frgListado);
                        fragmentListado.setKebabListener(MainActivity.this);
                    }
                    page = menu;

                    break;
            }
            container.addView(page, 0);

            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view,
                                        @NonNull Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }


}