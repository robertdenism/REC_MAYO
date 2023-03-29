package com.example.myapplication.ejCifrado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class Activity2Cifrado extends AppCompatActivity {

    TextView idTextoCifrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_cifrado);

        idTextoCifrado = findViewById(R.id.idtextoCifrado);

        boolean clicadoSimple = getIntent().getExtras().getBoolean("cifradoSimple");
        boolean clicadoMas = getIntent().getExtras().getBoolean("cifradoMas");
        int posiciones = getIntent().getExtras().getInt("posiciones");
        String texto = getIntent().getExtras().getString("texto");

        if (clicadoSimple==true){
           idTextoCifrado.setText(cifradoCesar(texto,posiciones));
        }else if (clicadoMas==true){
            idTextoCifrado.setText(cifradoCesarIncremental(texto,posiciones));
        }
    }

    public static String cifradoCesar(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        int longitudAlfabeto = 26;

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (Character.isLetter(letra)) {
                // Calcular la nueva posición de la letra
                int posicion = (int) letra;
                posicion += desplazamiento;
                if (Character.isUpperCase(letra)) {
                    if (posicion > 'Z') {
                        posicion -= longitudAlfabeto;
                    } else if (posicion < 'A') {
                        posicion += longitudAlfabeto;
                    }
                } else {
                    if (posicion > 'z') {
                        posicion -= longitudAlfabeto;
                    } else if (posicion < 'a') {
                        posicion += longitudAlfabeto;
                    }
                }
                // Agregar la letra cifrada al resultado
                resultado.append((char) posicion);
            } else {
                // Mantener los caracteres que no son letras sin cambios
                resultado.append(letra);
            }
        }
        return resultado.toString();
    }

    public static String cifradoCesarIncremental(String mensaje, int desplazamientoInicial) {
        StringBuilder resultado = new StringBuilder();
        int longitudAlfabeto = 26;
        int desplazamiento = desplazamientoInicial;
        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (Character.isLetter(letra)) {
                // Calcular la nueva posición de la letra
                int posicion = (int) letra;
                posicion += desplazamiento;
                if (Character.isUpperCase(letra)) {
                    if (posicion > 'Z') {
                        posicion -= longitudAlfabeto;
                    } else if (posicion < 'A') {
                        posicion += longitudAlfabeto;
                    }
                } else {
                    if (posicion > 'z') {
                        posicion -= longitudAlfabeto;
                    } else if (posicion < 'a') {
                        posicion += longitudAlfabeto;
                    }
                }
                // Agregar la letra cifrada al resultado
                resultado.append((char) posicion);
                // Incrementar el desplazamiento
                desplazamiento++;
            } else {
                // Mantener los caracteres que no son letras sin cambios
                resultado.append(letra);
            }
        }
        return resultado.toString();
    }
}