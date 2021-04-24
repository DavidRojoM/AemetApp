package com.example.aemetprevi_davidrojo;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Peticion {

    public void getPrevision(String localidad) {
        OkHttpClient cliente = new OkHttpClient();
        //construimos la peticion
        Request peticion = new Request.Builder()
                                .url("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/" +
                                                localidad + "? api_key=AQUIPONERLACLAVE")
                                .get()
                                .addHeader("cache-control", "no-cache")
                                .build();
        //realizamos la llamada al server, pero en otro thread (con enqueue)
        Call llamada = cliente.newCall(peticion);
        llamada.enqueue(new Callback() {
            public void onResponse(Call call, Response respuestaServer) throws IOException {
        //TENEMOS RESPUESTAS!!!!!

                String respuesta = respuestaServer.body().string();
        // Create a handler that associated with Looper of the main thread
                Handler manejador = new Handler(Looper.getMainLooper());

        // Send a task to the MessageQueue of the main thread
                manejador.post(new Runnable() {
                    @Override

                    public void run() {

        // Code will be executed on the main thread

                        Controlador miControlador = Controlador.getInstance();
                        miControlador.setRespuestaAPeticion(respuesta);

                    }
                });
            }
            public void onFailure(Call call, IOException e) {
                String respuesta = e.getMessage();
                Handler manejador = new Handler(Looper.getMainLooper());
        // Send a task to the MessageQueue of the main thread
                manejador.post(new Runnable() {
                    @Override

                    public void run() {

        // Code will be executed on the main thread

                        Controlador miControlador = Controlador.getInstance();
                        miControlador.setRespuestaAPeticion(respuesta);

                    }
                });
            }
        });
    }

}
