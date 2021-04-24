package com.example.aemetprevi_davidrojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected Controlador miControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miControlador = Controlador.getInstance();
        //cosas que hacer para inicializar sistemas, audio, fotos... etc.
    }

    //Comportamiento para responder al evento CLICK del button "consultar"

    public void onConsultar(View view){



        if (view.getDrawingCacheBackgroundColor()==0){
            view.setBackgroundColor(12345);

        }else
            view.setBackgroundColor(0);
    }


    

    //Aquí pondre miControlador.onConsultar(String codigoLocalidad)

}