package com.example.aemetprevi_davidrojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //ESTADO

    //Enlace al controlador
    protected Controlador miControlador;


    //COMPORTAMIENTO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvResultado);
        textView.setMovementMethod(new ScrollingMovementMethod());

        //cosas que hacer para inicializar sistemas, audio, fotos,...

        miControlador = Controlador.getInstance();
        Spinner spinner = (Spinner)findViewById(R.id.spinnerLocalidades);
        spinner.add
    }


    //Comportamiento para responder al evento CLICK del button "consultar"
    /** Called when the user touches the button */
    public void onConsultar(View view) {
        // Do something in response to button click


        //Aquí primero buscaremos el código de localidad en la pantalla
        //CUIDADO: si es vacío, no llamar al controlador, y mostrar en el
        //resultado, 'Usted no ha introducido ningún valor en "localidad"'


        //Aqui pondré: miControlador.onConsultar(String localidadCode);
        TextView tvResultado = (TextView)findViewById(R.id.tvResultado);
        tvResultado.setText("Accediendo a la web...");

        EditText etLocalidad = (EditText)findViewById(R.id.etLocalidad);

        miControlador.getPrevision(this,etLocalidad.getText().toString());

    }
}