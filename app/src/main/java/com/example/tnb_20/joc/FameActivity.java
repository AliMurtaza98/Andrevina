package com.example.tnb_20.joc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("name");
        int puntuacion= intent.getIntExtra("intentos",0);
        Player.players.add(new Player(nombre,puntuacion));

        Collections.sort(Player.players, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return new Integer(player1.getIntentos()).compareTo(new Integer(player2.getIntentos()));
            }
        });
            for(int i=0;i<Player.players.size();i++) {
            TableLayout tl = findViewById(R.id.table_layout);
            TableRow tr = new TableRow(getApplicationContext());

            TextView tw = new TextView(getApplicationContext());
            tw.setText(Player.players.get(i).getNombre());
            tr.addView(tw);
            tw.setPadding(145, 50, 0, 0);

            tw = new TextView(getApplicationContext());
            tw.setText(Player.players.get(i).getIntentos()+"");

            tr.addView(tw);
            tw.setPadding(150, 0,0 , 0);

            tl.addView(tr);
        }
    }
}
