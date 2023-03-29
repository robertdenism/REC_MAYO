package com.example.myapplication.ejJugador;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainJugador extends AppCompatActivity {

    private static final int NUMERO_ERROR = -1;
    private static final int NO_JUGADOR1 = 1;
    private static final int NO_JUGADOR2 = 2;

    private static final int NO_SELECCIONADO = 2131165339 ;

    ImageButton idJugador1, idJugador2;
    Button idBotonJugar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jugador);
        idJugador1 = findViewById(R.id.idJugador1);
        idJugador2 = findViewById(R.id.idJugador2);
        idBotonJugar = findViewById(R.id.idBotonJugar);
        idJugador1.setTag(R.drawable.help__1_);
        idJugador2.setTag(R.drawable.help__1_);

        Drawable imagenIncognito1 = idJugador1.getDrawable().;
        Drawable imagenIncognito2 = idJugador1.getDrawable();


        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String datos = data.getStringExtra("JUGADOR");
                        int noJugador = data.getIntExtra("noJugador", NUMERO_ERROR);
                        Toast.makeText(this, String.valueOf(noJugador), Toast.LENGTH_SHORT).show();
                        Drawable nuevaImagen = getResources().getDrawable(Integer.parseInt(datos));
                        if(noJugador == NO_JUGADOR1){
                            idJugador1.setImageDrawable(nuevaImagen);
                        }else if (noJugador == NO_JUGADOR2){
                            idJugador2.setImageDrawable(nuevaImagen);
                        }else{
                            Toast.makeText(this, "No se ha seleccionado jugador", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

        idJugador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainJugador.this, SeleccionaJugador.class);
                intent.putExtra("Jugador",NO_JUGADOR1);
                lanzadora.launch(intent);

            }
        });

        idJugador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainJugador.this, SeleccionaJugador.class);
                intent.putExtra("Jugador", NO_JUGADOR2);
                lanzadora.launch(intent);
            }
        });

        idBotonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(imagen1.toString()) == NO_SELECCIONADO){
                    Toast.makeText(MainJugador.this, "JUGADOR 1 NO HA SELECCIONADO", Toast.LENGTH_SHORT).show();
                }else if(Integer.parseInt(imagen2.toString()) == NO_SELECCIONADO){
                    Toast.makeText(MainJugador.this, "JUGADOR 2 NO HA SELECCIONADO", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainJugador.this, "A JUGAR", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}