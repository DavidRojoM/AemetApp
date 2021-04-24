package com.example.aemetprevi_davidrojo;

public class Controlador {

    private static  Controlador miControlador;
    private Peticion miPeticion;
    private Respuesta miRespuesta;

    private Controlador(){

    }

    public static Controlador getInstance(){
        if (miControlador==null){
            miControlador = new Controlador();
        }
        return miControlador;
    }

    public void setRespuestaAPeticion(String respuesta){

    }
}
