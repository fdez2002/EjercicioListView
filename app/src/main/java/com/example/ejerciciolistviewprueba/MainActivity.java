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

        lista = new ArrayList<>();
        lista.add(new Persona(R.drawable.hombre, "Miguel", "López Sanchez", "ASIR"));
        lista.add(new Persona(R.drawable.hombre,"Juan", "Pérez Pérez", "DAW"));
        lista.add(new Persona(R.drawable.mujer,"María", "Martinez Fernandez", "DAM"));
        lista.add(new Persona(R.drawable.hombre,"Antonio", "Gonzalez García", "DAM"));
        lista.add(new Persona(R.drawable.mujer,"Ana", "Diaz Torres", "ASIR"));




        PersonaAdapter personaAdapter = new PersonaAdapter(this, R.layout.list_row, lista);

        listViewPersonas.setAdapter(personaAdapter);


        //Evento cambio de activity
        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(view.getContext(), Modulos.class);


                String cadena = lista.get(i).getCiclo();
                intent.putExtra("CICLO", cadena);
                startActivity(intent);

            }
        });
    }
}