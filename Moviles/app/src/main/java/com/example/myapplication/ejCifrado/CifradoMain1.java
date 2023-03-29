package com.example.myapplication.ejCifrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.myapplication.R;
import com.example.myapplication.colorTexto.Activity2;

public class CifradoMain1 extends AppCompatActivity {

    RadioButton idCifradoSimple, idCIfradoMas;
    EditText idPosiciones, idTextoACirfrar;
    Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cifrado_main);

        idCifradoSimple = findViewById(R.id.idRadioSimple);
        idCIfradoMas = findViewById(R.id.idRadioMas);

        idPosiciones = findViewById(R.id.idPosiciones);
        idTextoACirfrar = findViewById(R.id.idTextoACifrar);

        enviar = findViewById(R.id.idCifrar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envio();
            }
        });
    }

    public void envio(){
        Intent intent = new Intent(this, Activity2Cifrado.class);
        boolean clicadoSimple = idCifradoSimple.isChecked();
        boolean clicadoMas = idCIfradoMas.isChecked();
        int posiciones = Integer.parseInt(idPosiciones.getText().toString());
        String texto = idTextoACirfrar.getText().toString();


        intent.putExtra("posiciones", posiciones);
        intent.putExtra("texto", texto);
        intent.putExtra("cifradoSimple", clicadoSimple);
        intent.putExtra("cifradoMas", clicadoMas);

        startActivity(intent);

    }
}