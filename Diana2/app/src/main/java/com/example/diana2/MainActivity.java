package com.example.diana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int[][] idsPuntuacion = {
            {R.id.boton1, 1},{R.id.boton2, 2},{R.id.boton3, 3},{R.id.boton4, 4},
            {R.id.boton5, 5},{R.id.boton6, 6},{R.id.boton7, 7},{R.id.boton8, 8},
            {R.id.boton9, 9},{R.id.boton10, 10},{R.id.boton11, 11},{R.id.boton12, 12},
            {R.id.boton13, 13},{R.id.boton14, 14},{R.id.boton15, 15},{R.id.boton16, 16},
            {R.id.boton17, 17},{R.id.boton18, 18},{R.id.boton19, 19},{R.id.boton20, 20},
            {R.id.boton25, 25},{R.id.boton50, 50}};

    int jugadorActual = 0;

    int[] marcadores = {0, 0, 0, 0};

    TextView puntuacion, jugadorT;

    int numeroActual = 0;
    int numeroActualMulti = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }else{
            setContentView(R.layout.horizontal);
        }

        puntuacion = (TextView) findViewById(R.id.textView2);
        jugadorT = (TextView) findViewById(R.id.textView3);
    }

    public void puntuacion(View v){
        for(int i = 0; i <22; i++){
            if(v.getId() == idsPuntuacion[i][0]){
                numeroActual = idsPuntuacion[i][1];
                numeroActualMulti = 0;
                marcadores[jugadorActual] += numeroActual;
                actualizarPuntuacion();
            }
        }
    }

    public void doble(View v){
        if(numeroActualMulti != 0){
            marcadores[jugadorActual] -= numeroActualMulti;
        }else{
            marcadores[jugadorActual] -= numeroActual;
        }
        numeroActualMulti = numeroActual*2;
        marcadores[jugadorActual] += numeroActual*2;
        actualizarPuntuacion();
    }

    public void triple(View v){
        if(numeroActualMulti != 0){
            marcadores[jugadorActual] -= numeroActualMulti;
        }else{
            marcadores[jugadorActual] -= numeroActual;
        }
        numeroActualMulti = numeroActual*3;
        marcadores[jugadorActual] += numeroActual*3;
        actualizarPuntuacion();
    }

    public void actualizarPuntuacion(){
        puntuacion.setText("Puntuación: "+marcadores[jugadorActual]);
    }

    public void elegirJugador(View v){
        Button b = (Button)v;
        int jugador = 0;
        String jugadorCadena = b.getText().toString();
        switch (jugadorCadena){
            case "J1":
                jugadorT.setTextColor(Color.parseColor("#FF0000"));
                break;
            case "J2":
                jugador = 1;
                jugadorT.setTextColor(Color.parseColor("#003EFF"));
                break;
            case "J3":
                jugador = 2;
                jugadorT.setTextColor(Color.parseColor("#2FB84C"));
                break;
            case "J4":
                jugador = 3;
                jugadorT.setTextColor(Color.parseColor("#FFD500"));
                break;
        }
        if(jugador != jugadorActual){
            jugadorT.setText(jugadorCadena);
            numeroActualMulti = 0;
            numeroActual = 0;
            jugadorActual = jugador;
            actualizarPuntuacion();
        }
    }
}
