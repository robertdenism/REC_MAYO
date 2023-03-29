package com.example.myapplication.ejJugador;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

       // int imageId = getResources().getIdentifier("help__1_", "drawable", getPackageName());




        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String datos = data.getStringExtra("JUGADOR");
                        int noJugador = data.getIntExtra("noJugador", NUMERO_ERROR);
                        Drawable nuevaImagen = getResources().getDrawable(Integer.parseInt(datos));
                        if(noJugador == NO_JUGADOR1){
                            idJugador1.setImageDrawable(nuevaImagen);
                            idJugador1.setTag(Integer.parseInt(datos));
                        }else if (noJugador == NO_JUGADOR2){
                            idJugador2.setImageDrawable(nuevaImagen);
                            idJugador2.setTag(Integer.parseInt(datos));
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
                intent.putExtra("paraGris", String.valueOf(idJugador2.getTag()));
                lanzadora.launch(intent);

            }
        });

        idJugador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainJugador.this, SeleccionaJugador.class);
                intent.putExtra("Jugador", NO_JUGADOR2);
                intent.putExtra("paraGris", String.valueOf(idJugador1.getTag()));
                lanzadora.launch(intent);
            }
        });

        idBotonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HAY que parsearlo a string y luego a int
                String comprueba1 = String.valueOf(idJugador1.getTag());
                String comprueba2 = String.valueOf(idJugador2.getTag());
                int comprobador1 = Integer.parseInt(comprueba1);
                int comprobador2 = Integer.parseInt(comprueba2);

                if (comprobador1 == NO_SELECCIONADO &&  comprobador2 == NO_SELECCIONADO){
                    Toast.makeText(MainJugador.this, "NO SE HA SELECCIONADO PERSONAJE", Toast.LENGTH_SHORT).show();
                }else if(comprobador1 == NO_SELECCIONADO){
                    Toast.makeText(MainJugador.this, "JUGADOR 1 NO SELECCIONADO", Toast.LENGTH_SHORT).show();
                }else if(comprobador2 == NO_SELECCIONADO){
                    Toast.makeText(MainJugador.this, "JUGADOR 2 NO SELECCIONADO", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainJugador.this, "A JUGAAR!!!", Toast.LENGTH_SHORT).show();

                }



            }
        });

    }
}