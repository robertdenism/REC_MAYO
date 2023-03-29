package com.example.myapplication.colorTexto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class Activity2 extends AppCompatActivity {
    private static final int VALOR_MAXIMO = 255;
    private static final int VALOR_MINIMO = 0;

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        texto = findViewById(R.id.idText);

        String R = getIntent().getExtras().getString("R");
        String G = getIntent().getExtras().getString("G");
        String B = getIntent().getExtras().getString("B");
        String mensaje = getIntent().getExtras().getString("mensaje");

        texto.setText(mensaje);

        //El string recibido lo convertimos a integer
        int intHexaR = Integer.parseInt(R);
        int intHexaG = Integer.parseInt(G);
        int intHexaB = Integer.parseInt(B);

        //los int convertidos los convertimos a hexadecimal
        String hexadecimalR = Integer.toHexString(intHexaR);
        String hexadecimalG = Integer.toHexString(intHexaG);
        String hexadecimalB = Integer.toHexString(intHexaB);

        //Le damos color al texto

        texto.setTextColor(Color.parseColor("#"+hexadecimalR+hexadecimalG+hexadecimalB));



    }
}