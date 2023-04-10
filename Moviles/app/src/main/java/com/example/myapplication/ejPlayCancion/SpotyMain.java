package com.example.myapplication.ejPlayCancion;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class SpotyMain extends AppCompatActivity {

    Button botonVerLista, botonPlay;
    EditText textoSeleccionPista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoty_main);



        botonVerLista = findViewById(R.id.botonVerLista);
        botonPlay = findViewById(R.id.botonPlay);
        textoSeleccionPista = findViewById(R.id.textoSeleccionPista);

        botonPlay.setOnClickListener(new View.OnClickListener() {
            private static final int PUERTO = 12345;
            private static final String IP = "192.168.1.122";
            @Override
            public void onClick(View view) {
                int numeroPista = Integer.parseInt(textoSeleccionPista.getText().toString());

                String mensaje = "play"+numeroPista;

                try {
                    DatagramSocket socket = new DatagramSocket();
                    // Crear un objeto DatagramPacket con el mensaje y la dirección del servidor
                    byte[] buffer = mensaje.getBytes();
                    InetAddress address = InetAddress.getByName(IP);
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PUERTO);

                    // Enviar el paquete al servidor
                    socket.send(packet);

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}