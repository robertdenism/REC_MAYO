package com.example.myapplication.ejPropina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Propina2 extends AppCompatActivity {

    private static final int PORCENTAJE_BUENO = 15;
    private static final int PORCENTAJE_EXCELENTE = 20;
    private static final boolean VERDADERO = true;

    TextView idPrecio, idPropina, idTotal, idTextoPrincipal;
    Button idBotonVolver, idBotonOtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propina2);

        idPrecio = findViewById(R.id.idPrecio);
        idTotal = findViewById(R.id.idTotal);
        idPropina = findViewById(R.id.idPropina);
        idTextoPrincipal = findViewById(R.id.idTextoPrincipal);

        idBotonVolver = findViewById(R.id.idBotonVolver);
        idBotonOtra = findViewById(R.id.idBotonOtra);


        boolean valorRadioMalo = getIntent().getExtras().getBoolean("Malo");
        boolean valorRadioBueno = getIntent().getExtras().getBoolean("Bueno");
        boolean valorRadioMuy = getIntent().getExtras().getBoolean("Muy");
        float valorCantidad = getIntent().getExtras().getFloat("Cantidad");



        if (VERDADERO == valorRadioMalo) {
            idTextoPrincipal.setText("Su valoración ha sido Malo, se aplica un 0% de propina");
            idPropina.setText("0%");
            idPrecio.setText(valorCantidad+"€");
            idTotal.setText(valorCantidad+"€");
        } else if (VERDADERO == valorRadioBueno) {
            idTextoPrincipal.setText("Su valoración ha sido Bueno, se aplica un "+ PORCENTAJE_BUENO + "% de propina");
            float propina= calculoPropina(PORCENTAJE_BUENO,valorCantidad);
            idPrecio.setText(valorCantidad+"€");
            idPropina.setText(propina+"€");
            idTotal.setText(valorCantidad+propina+"€");
        } else if (VERDADERO == valorRadioMuy) {
            idTextoPrincipal.setText("Su valoración ha sido Excelente, se aplica un "+ PORCENTAJE_EXCELENTE+ "% de propina");
            float propina = calculoPropina(PORCENTAJE_EXCELENTE,valorCantidad);
            if (propina>PORCENTAJE_EXCELENTE){
                propina=PORCENTAJE_EXCELENTE;
            }
            idPrecio.setText(valorCantidad+"€");
            idPropina.setText(propina+"€");
            idTotal.setText(valorCantidad+propina+"€");
        }
        idBotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });
        idBotonOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOtra();
            }
        });

    }
    public static float calculoPropina(int porciento, float cantidad){
        float calculo = (porciento*cantidad)/100;
        return calculo;
    }

    public void volver(){
        onBackPressed();
    }
    public void calcularOtra(){
        finish();
        Intent intent = new Intent(this, MainPropina.class);
        startActivity(intent);
    }

}