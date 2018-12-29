package com.example.farmaciasdeturno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


/*Se crea un objeto de tipo informacion donde se settean los datos
* correspondientes a cada farmacia.
* Luego se agrega a la lista de datos. */

public class ActividadInfo extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<Informacion> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_info);

        listaDatos=findViewById(R.id.listInfo);
        lista=new ArrayList<Informacion>();
        lista.add( new Informacion(1, "Americana", "Horario:\n8-12hs-16-20hs.", "Direccion:\nCiudad de Rodez 402. ", R.drawable.farmacia));
        lista.add( new Informacion(2, "Aostri", "Horario:\n8-12:30hs-16-20:30hs.", "Direccion:\nAv Mitre 417. ", R.drawable.farmacia));
        lista.add( new Informacion(6, "Del Pueblo", "Horario:\n8-12hs-16-20hs.", "Direccion:\nAv Casey 76. ", R.drawable.farmacia));
        lista.add( new Informacion(3, "Fenoglio", "Horario:\n8-12hs-15-20hs.", "Direccion:\nL.V Lopez 99. ", R.drawable.farmacia));
        lista.add( new Informacion(4, "Fidalgo", "Horario:\n8-12:30hs-16-21hs.", "Direccion:\nAlvear y Pellegrini. ", R.drawable.farmacia));
        lista.add( new Informacion(5, "Francesa", "Horario:\n8-12hs-16-20hs.", "Direccion:\nAv Casey 270. ", R.drawable.farmacia));
        lista.add( new Informacion(7, "Pigué", "Horario:\n8-12hs-16-20hs.", "Direccion:\nRivadavia 480. ", R.drawable.farmacia));
        lista.add( new Informacion(8, "Sitz", "Horario:\n8-12:30hs-16-21hs.", "Direcion:\nAv Casey 965. ", R.drawable.farmacia));


        Adaptador Miadapter= new Adaptador(getApplicationContext(),lista);
        listaDatos.setAdapter(Miadapter);

    }


}
