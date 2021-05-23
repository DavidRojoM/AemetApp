package com.example.aemetprevi_davidrojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RespuestaTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getInforme() {

        /*
        * Construimos un objeto Respuesta con parámetro de entrada "Hola"
        * */
        Respuesta respuesta = new Respuesta("Hola",0);

        /*
        * Comprobamos que el método getInforme() nos devuelve "Hola"
        * */

        String resultado = respuesta.getInforme();

        assertEquals("Hola",resultado);
    }

    @Test
    public void getUrl() {

        /*
        * EL JSON CORRESPONDE A LA LOCALIDAD CON CODIGO 29069 (MARBELLA)
        * */

        String json = "{\n" +
                "  \"descripcion\" : \"exito\",\n" +
                "  \"estado\" : 200,\n" +
                "  \"datos\" : \"https://opendata.aemet.es/opendata/sh/8723e390\",\n" +
                "  \"metadatos\" : \"https://opendata.aemet.es/opendata/sh/dfd88b22\"\n" +
                "}";


        /*
        * Probamos el comportamiento del metodo getUrl cuando Respuesta tiene el turno 1
        * */

        Respuesta respuesta = new Respuesta(json,1);

        assertEquals("https://opendata.aemet.es/opendata/sh/8723e390",respuesta.getUrl());

    }
}