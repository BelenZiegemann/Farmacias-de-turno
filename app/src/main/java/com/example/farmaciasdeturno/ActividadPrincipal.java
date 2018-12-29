package com.example.farmaciasdeturno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;




public class ActividadPrincipal extends AppCompatActivity {


    Button bInfo, bTurnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);




        //Oyente de boton Informacion
        bInfo = findViewById(R.id.bInfo);
        bInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActividadInfo.class);
                startActivity(i);
            }

        });


        bTurnos = findViewById(R.id.bTurnos);
        bTurnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActividadTurnos.class);
                startActivity(i);
            }

        });

    }

    @Override public boolean onCreateOptionsMenu(Menu mimenu){

        getMenuInflater().inflate(R.menu.menu,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected (MenuItem opcion){

        //int id=opcion.getItemId();

        Intent i = new Intent(getApplicationContext(), AcercaDe.class);
        startActivity(i);

        return true;
    }


}
