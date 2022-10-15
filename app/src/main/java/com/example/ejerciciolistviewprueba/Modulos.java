package com.example.ejerciciolistviewprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Modulos extends AppCompatActivity {

    private ImageView imagenCiclo;
    private TextView textoDeCiclo;
    private Button botonVolver;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        this.window = getWindow();

        //imagenCiclo = findViewById(R.id.imageViewCicloInfo);
        textoDeCiclo = findViewById(R.id.textViewCicloInfo);
        botonVolver = findViewById(R.id.button);
        imagenCiclo = findViewById(R.id.imageViewCicloInfo);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
       //String texto = b.getString("CICLO");

        //textoDeCiclo.setText(b.getString("CICLO"));

        switch ( b.getString("CICLO")){//Recibimos el ciclo seleccionado y segun el ciclo configuramos la activity de una forma u otra
            case "DAM":
                textoDeCiclo.setText("Estás en el ciclo de DAM");//Texto que se muestra
                imagenCiclo.setImageResource(R.drawable.img_2);//Imagen que se muestra
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c1ff65")));//Color de fondo del activity
                break;
            case "DAW":
                textoDeCiclo.setText("Estás en el ciclo de DAW");
                imagenCiclo.setImageResource(R.drawable.img_1);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff5436")));
                break;
            case "ASIR":
                textoDeCiclo.setText("Estás en el ciclo de ASIR");
                imagenCiclo.setImageResource(R.drawable.img);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#b675ff")));
                break;
        }

    }

    //Boton de volver a la main
    public void volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}