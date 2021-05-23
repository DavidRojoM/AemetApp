package com.example.aemetprevi_davidrojo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeticionTest {
    Peticion miPeticion;


    @Before
    public void setUp() throws Exception {
        miPeticion = new Peticion();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPrevision() throws InterruptedException {
        assertNull(miPeticion.getUltimaRespuesta());
        miPeticion.getPrevision("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/29069?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXMuYWxjYXJhekBwb2xpdGVjbmljb21hbGFnYS5jb20iLCJqdGkiOiJjOTc3MjI0OC0xYzNiLTQ4ODAtYjYxYy04YWE5NjNmNGE0YmYiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTYxNzcwNzMyOCwidXNlcklkIjoiYzk3NzIyNDgtMWMzYi00ODgwLWI2MWMtOGFhOTYzZjRhNGJmIiwicm9sZSI6IiJ9.GojMAUMYA_BPK17JnzoxQsVqPgy2y7qQkH9XUGh6qnE",false);
        Thread.sleep(5000);
        System.out.println(miPeticion.getUltimaRespuesta());
        assertNotNull(miPeticion.getUltimaRespuesta());

    }
}