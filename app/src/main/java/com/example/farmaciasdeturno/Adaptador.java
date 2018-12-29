package com.example.farmaciasdeturno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/* BaseAdapter--> para generar todos los metodos de adaptador.
* Contexto--> el entorno de la aplicacion. Toodo lo que esta utilizando
* Se utiliza para que se pueda generar el adaptador.
* */
public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Informacion> listaDeObjetos;

    public Adaptador(Context contexto, List<Informacion> listaDeObjetos) {
        this.contexto = contexto;
        this.listaDeObjetos = listaDeObjetos;
    }

    @Override
    public int getCount() {
        return listaDeObjetos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDeObjetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaDeObjetos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista= view;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.customlayout, null);
        ImageView imagen = vista.findViewById(R.id.imageView);
        TextView nombre= vista.findViewById(R.id.tNombre);
        TextView horario=vista.findViewById(R.id.tHorario);
        TextView direccion=vista.findViewById(R.id.tDireccion);

        nombre.setText(listaDeObjetos.get(i).getNombre().toString());
        horario.setText(listaDeObjetos.get(i).getHorario().toString());
        direccion.setText(listaDeObjetos.get(i).getDireccion().toString());
        imagen.setImageResource(listaDeObjetos.get(i).getImagen());

        return vista;
    }
}
