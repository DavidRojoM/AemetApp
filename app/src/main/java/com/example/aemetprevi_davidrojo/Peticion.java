package com.example.aemetprevi_davidrojo;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Peticion {
    //ESTADO

    //protected String localidad;
    static protected int turno = 0;
    private String ultimaRespuesta;

    //COMPORTAMIENTO
    public Peticion() {

    }

    public String getUltimaRespuesta() {
        return ultimaRespuesta;
    }

    public void setUltimaRespuesta(String ultimaRespuesta) {
        this.ultimaRespuesta = ultimaRespuesta;
    }

    public void getPrevision(String URL, boolean publicar) {
        OkHttpClient cliente = new OkHttpClient();
        final int nuevoTurno = (Peticion.turno+1)%2;
        Peticion.turno = nuevoTurno;

        //construimos la peticion
        try{
            Request peticion = new Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .build();


            //realizamos la llamada al server, pero en otro thread (con enqueue)
            Call llamada = cliente.newCall(peticion);
            llamada.enqueue(new Callback() {
                public void onResponse(Call call, Response respuestaServer)
                        throws IOException {
                    //TENEMOS RESPUESTAS!!!!!
                    String respuesta = respuestaServer.body().string();
                    setUltimaRespuesta(respuesta);
                    if (publicar){
                        // Create a handler that associated with Looper of the main thread
                        Handler manejador = new Handler(Looper.getMainLooper());

                        // Send a task to the MessageQueue of the main thread
                        manejador.post(new Runnable() {
                            @Override
                            public void run() {
                                // Code will be executed on the main thread
                                Controlador miControlador = Controlador.getInstance();
                                miControlador.setRespuestaAPeticion(respuesta,nuevoTurno);
                            }
                        });
                    }
                }

                public void onFailure(Call call, IOException e) {
                    String respuesta = e.getMessage();
                    setUltimaRespuesta(respuesta);
                    if (publicar){
                        Handler manejador = new Handler(Looper.getMainLooper());

                        // Send a task to the MessageQueue of the main thread
                        manejador.post(new Runnable() {
                            @Override
                            public void run() {
                                // Code will be executed on the main thread
                                Controlador miControlador = Controlador.getInstance();
                                miControlador.setRespuestaAPeticion(respuesta,-1);
                            }
                        });
                    }
                }
            });

        }catch (Exception e){
            Controlador miControlador = Controlador.getInstance();
            MainActivity mainActivity = miControlador.getMiActivity();
            TextView tvResultado = (TextView)mainActivity.findViewById(R.id.tvResultado);
            tvResultado.setText(R.string.localidadError);

            WebView webView = (WebView)mainActivity.findViewById(R.id.webview);
            webView.loadUrl("");

            e.printStackTrace();
        }






    }

}
