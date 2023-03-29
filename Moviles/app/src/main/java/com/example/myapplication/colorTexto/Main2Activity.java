package com.example.myapplication.colorTexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.colorTexto.Activity2;

public class Main2Activity extends AppCompatActivity {

    private static final int VALOR_MAXIMO = 255;
    private static final int VALOR_MINIMO = 0;
    EditText idR, idB, idG, idMensaje;
    Button idEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idR = findViewById(R.id.idR);
        idG = findViewById(R.id.idG);
        idB = findViewById(R.id.idB);
        idMensaje = findViewById(R.id.idMensaje);
        idEnviar = findViewById(R.id.idEnviar);

            idEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        enviar();
                }
            });

    }
    public void enviar(){



            Intent intent = new Intent(this, Activity2.class);
            String R = idR.getText().toString();
            String G = idG.getText().toString();
            String B = idB.getText().toString();
            String mensaje = idMensaje.getText().toString();

            intent.putExtra("R", R);
            intent.putExtra("G", G);
            intent.putExtra("B", B);
            intent.putExtra("mensaje", mensaje);

            startActivity(intent);


    }

}

