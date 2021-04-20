package com.example.aemetprevi_davidrojo;

import java.io.IOException;

public class Peticion {

    public void getPrevision(){
        Response response;
        String resultado;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url();
                .get();
                .addHeader();
                .build();

                Call llamada = client.newCall(request);
                llamada.enqueue(new Callback(){
                    public void onResponse(Call call, Response respuestaServer) throws IOException{
                        Controlador miControlador = Controlador.getInstance();
                        miControlador.setRespuestaAPeticion(respuestaServer.)
                    }

                    public void onFailure(Call call, IOException ioException){

                    }
        });
    }

}
