package com.example.ejerciciolistviewprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewPersonas;
    private ArrayList<Persona> lista;
    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPersonas = findViewById(R.id.listView);

        //Añadimos contenido al arrayList de la clase personas
        lista = new ArrayList<>();
        lista.add(new Persona(R.drawable.hombre, "Miguel", "López Sanchez", "ASIR"));//persona1
        lista.add(new Persona(R.drawable.hombre,"Juan", "Pérez Pérez", "DAW"));//persona2
        lista.add(new Persona(R.drawable.mujer,"María", "Martinez Fernandez", "DAM"));//persona3
        lista.add(new Persona(R.drawable.hombre,"Antonio", "Gonzalez García", "DAM"));//persona4
        lista.add(new Persona(R.drawable.mujer,"Ana", "Diaz Torres", "ASIR"));//persona5


        //Le pasamos ala clase PersonaAdapter el contexto, el layout y la lista de las personas
        PersonaAdapter personaAdapter = new PersonaAdapter(this, R.layout.list_row, lista);

        listViewPersonas.setAdapter(personaAdapter);


        //Evento cambio de activity
        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Usamos el intent que nos ayuda a enviar datos a otro componente de nuestra app
                Intent intent = new Intent(view.getContext(), Modulos.class);


                //String cadena = lista.get(i).getCiclo();
                intent.putExtra("CICLO", lista.get(i).getCiclo());//Enviamos el ciclo seleccioando co  su nombre
                startActivity(intent);

            }
        });
    }
}