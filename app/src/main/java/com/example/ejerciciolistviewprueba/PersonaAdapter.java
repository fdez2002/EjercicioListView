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
    private Context mContext;
    private int mresource;

    public PersonaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Persona> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mresource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);

        TextView textNombre = convertView.findViewById(R.id.textViewNombre);
        TextView textApellidos = convertView.findViewById(R.id.textViewApellidos);
        TextView textCurso = convertView.findViewById(R.id.textViewCurso);

        imageView.setImageResource(getItem(position).getImagen());
        textNombre.setText(getItem(position).getNombre());
        textApellidos.setText(getItem(position).getApellidos());
        textCurso.setText(getItem(position).getCiclo());

        return convertView;
    }
}
