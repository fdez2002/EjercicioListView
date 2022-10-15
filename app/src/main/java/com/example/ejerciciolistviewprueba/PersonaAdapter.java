package com.example.ejerciciolistviewprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private Context mContext;//Para asignar los datos
    private int mresource;
    //Elementos de cada item
    private TextView textNombre;
    private TextView textApellidos;
    private TextView textCurso;
    private ImageView imageView;

    //Constructor donde le pasamos el contexto, de donde obtiene los datos y el resource que va a ser el layout de cada item
    public PersonaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Persona> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mresource = resource;
    }

    //COn este metodo buscamos las vistas que vamos a poner en cada elemento del listView;
    //LO implementamos con get View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Instanciamos el archivo xml que le pasamos en el main
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mresource, parent, false);

        //Asignamos los elementos con el id del layaut pasado en el main
        imageView = convertView.findViewById(R.id.imageView);
        textNombre = convertView.findViewById(R.id.textViewNombre);
        textApellidos = convertView.findViewById(R.id.textViewApellidos);
        textCurso = convertView.findViewById(R.id.textViewCurso);

        //Le asignamos los datos que va a tener la vista, con la posicion del elemento
        imageView.setImageResource(getItem(position).getImagen());
        textNombre.setText(getItem(position).getNombre());
        textApellidos.setText(getItem(position).getApellidos());
        textCurso.setText(getItem(position).getCiclo());

        return convertView;//Retornamos la vista
    }
}
