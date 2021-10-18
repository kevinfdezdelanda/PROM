package com.example.listas_e_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Ej02 extends AppCompatActivity {

    private ListView listWebs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej02);

        ImageView imgYoutube = new ImageView(this);
        imgYoutube.setImageResource(R.drawable.youtube);

        ImageView imgTwitch = new ImageView(this);
        imgTwitch.setImageResource(R.drawable.twitch);

        ImageView imgAmazon = new ImageView(this);
        imgAmazon.setImageResource(R.drawable.amazon);

        ImageView imgNetflix = new ImageView(this);
        imgNetflix.setImageResource(R.drawable.netflix);

        listWebs = (ListView) findViewById(R.id.listWebs);

        final Web[] webs = new Web[] {
            new Web("Youtube", "https://www.youtube.com/", "w1", imgYoutube),
            new Web("Twitch", "https://www.twitch.tv/", "w2", imgTwitch),
            new Web("Amazon", "https://www.amazon.es/", "w3", imgAmazon),
            new Web("Netflix", "https://www.netflix.com/es/", "w4", imgNetflix)
        };

        AdaptadorWebs adaptadorWebs =
                new AdaptadorWebs(this, webs);
        listWebs.setAdapter(adaptadorWebs);

        listWebs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Alternativa 1:
                Web web = ((Web)parent.getItemAtPosition(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(web.getUrl()));
                startActivity(intent);
            }
        });
    }

+
}