package com.example.myapplication.ejPropina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.myapplication.R;
import com.example.myapplication.ejCifrado.Activity2Cifrado;

public class MainPropina extends AppCompatActivity {

    EditText idCantidad;
    RadioButton idRadioMalo, idRadioBueno, idRadioMuy;
    Button idBotonValorar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_propina);

        idCantidad = findViewById(R.id.idCantidad);

        idRadioMalo = findViewById(R.id.idRadioMalo);
        idRadioMuy = findViewById(R.id.idRadioMuy);
        idRadioBueno = findViewById(R.id.idRadioBueno);

        idBotonValorar = findViewById(R.id.idBotonValorar);

        idBotonValorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar();
            }
        });
    }
    public void enviar(){

        boolean valorMalo = idRadioMalo.isChecked();
        boolean valorBueno = idRadioBueno.isChecked();
        boolean valorMuy = idRadioMuy.isChecked();
        float valorCantidad = Float.parseFloat(idCantidad.getText().toString());

        Intent intent = new Intent(this, Propina2.class);
        intent.putExtra("Malo", valorMalo);
        intent.putExtra("Bueno", valorBueno);
        intent.putExtra("Muy", valorMuy);
        intent.putExtra("Cantidad", valorCantidad);

        startActivity(intent);
    }
}