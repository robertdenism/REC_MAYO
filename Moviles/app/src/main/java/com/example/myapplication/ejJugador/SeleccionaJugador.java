package com.example.myapplication.ejJugador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SeleccionaJugador extends AppCompatActivity {

    private static final int TAMANIO_ARRAY = 8;
    ImageButton jugador1, jugador2,jugador3,jugador4,jugador5,jugador6,jugador7,jugador8;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_jugador);

        int noJugador = getIntent().getExtras().getInt("Jugador");
        String paraGris = getIntent().getExtras().getString("paraGris");



        Toast.makeText(this, paraGris, Toast.LENGTH_SHORT).show();

        jugador1 = findViewById(R.id.jugador1);
        jugador2 = findViewById(R.id.jugador2);
        jugador3 = findViewById(R.id.jugador3);
        jugador4 = findViewById(R.id.jugador4);
        jugador5 = findViewById(R.id.jugador5);
        jugador6 = findViewById(R.id.jugador6);
        jugador7 = findViewById(R.id.jugador7);
        jugador8 = findViewById(R.id.jugador8);

        jugador1.setTag(R.drawable._1off);
        jugador2.setTag(R.drawable._2off);
        jugador3.setTag(R.drawable._3off);
        jugador4.setTag(R.drawable._4off);
        jugador5.setTag(R.drawable._5off);
        jugador6.setTag(R.drawable._6off);
        jugador7.setTag(R.drawable._7off);
        jugador8.setTag(R.drawable._9off);



        jugador1.setTag(R.drawable._1);
        jugador2.setTag(R.drawable._2);
        jugador3.setTag(R.drawable._3);
        jugador4.setTag(R.drawable._4);
        jugador5.setTag(R.drawable._5);
        jugador6.setTag(R.drawable._6);
        jugador7.setTag(R.drawable._7);
        jugador8.setTag(R.drawable._9);
//ESTO ES PARA UNA PRUEBA
        String[] miArray = {
                String.valueOf(jugador1.getTag()),
                String.valueOf(jugador2.getTag()),
                String.valueOf(jugador3.getTag()),
                String.valueOf(jugador4.getTag()),
                String.valueOf(jugador5.getTag()),
                String.valueOf(jugador6.getTag()),
                String.valueOf(jugador7.getTag()),
                String.valueOf(jugador8.getTag())
        };
     //TODAVIA HAY QUE MIRARLO Y LAS EXCEPCIONES YA QUE NO RECIBE NADA AL PRINCIPIO
        for(int i=0; i<=miArray.length; i++){
            if ((miArray[i]).equals(paraGris)){
                Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
            }
        }




        jugador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                envioImagenes(view, noJugador);


                /*Drawable nuevaImagen = getResources().getDrawable(R.drawable._1off);
                jugador1.setImageDrawable(nuevaImagen);*/
            }
        });
        jugador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });
        jugador8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioImagenes(view, noJugador);
            }
        });

    }
    public void envioImagenes(View view, int noJugador){
        ImageButton imgButton = (ImageButton) view;
        Intent intent = new Intent();
        intent.putExtra("JUGADOR", imgButton.getTag().toString());
        intent.putExtra("noJugador", noJugador);
        setResult(Activity.RESULT_OK, intent);
        onBackPressed();
    }
}