package com.example.farmaciasdeturno;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActividadTurnos extends AppCompatActivity {

    Button bFecha, bBuscar;
    TextView eFecha, eNombre;
    public int dia, mes, ano, diaAux,mesAux;
    String farmacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_turnos);


        bFecha = findViewById(R.id.bFecha);
        eFecha = findViewById(R.id.eFecha);
        eNombre = findViewById(R.id.eNombre);
        bBuscar = findViewById(R.id.bBuscar);
        bBuscar.setEnabled(false);



        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    farmacia=buscarFile(diaAux,mesAux);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eNombre.setText(farmacia);
            }
        });


        bFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eNombre.setText(null);
                mostrarFecha();
            }

        });

    }

    /*Convierte el dia, mes y año seleccionado por el usuario y los almacena en las
    * respectivas variables.
    * Si el año seleccionado no es el actual, se imprimira por pantalla un mensaje comunicando
    * que la informacion no esta disponible.
    * No es posible ingresar una fecha anterior a la actual.*/

    private void mostrarFecha(){
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);



        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                if(i>2018){
                    Toast.makeText(getApplicationContext(), "INFORMACION NO DISPONIBLE", Toast.LENGTH_LONG).show();
                    eFecha.setText(null);
                    bBuscar.setEnabled(false);
                }

                else {
                    c.set(Calendar.YEAR, i);
                    c.set(Calendar.MONTH, i1);
                    c.set(Calendar.DAY_OF_MONTH, i2);
                    diaAux=i2;
                    mesAux=i1+1;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                    eFecha.setText(sdf.format(c.getTime()));
                    bBuscar.setEnabled(true);

                }
            }
        }
                ,ano,mes,dia);
        c.set(ano, mes,dia);

        long valor=c.getTimeInMillis();
        datePickerDialog.getDatePicker().setMinDate(valor);
        datePickerDialog.show();


    }

    /*Busca en el archivo la fecha seleccionada por el usuario.*/
    private String buscarFile( int i1, int i2) throws IOException {

        String linea, farmacia=" ";
        int d, m;
        boolean encontre=false;
        InputStream file=this.getResources().openRawResource(R.raw.datos);
        BufferedReader reader=new BufferedReader(new InputStreamReader(file));
        if(file!=null){
            while((linea=reader.readLine())!=null && !encontre) {
                d= Integer.parseInt(linea.split(";")[0]);
                m=Integer.parseInt(linea.split(";")[1]);
                if(i1==d && i2==m){
                    farmacia=linea.split(";")[2];
                    encontre=true;
                }
            }
        }
        return farmacia;
    }


}
