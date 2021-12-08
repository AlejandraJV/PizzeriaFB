package com.example.pizzeriafb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Models.Pizzas;

public class Gestion_act extends AppCompatActivity {

    private EditText nom, precio, loc;
    private Button btn;

    //declaro variables para obtener mi database
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        //Llamamos elementos por id
        nom = findViewById(R.id.nom);
        precio = findViewById(R.id.precio);
        loc = findViewById(R.id.precio);
        btn = findViewById(R.id.btn);

        obtenerDataBase(); //instanciamos la database

        //Añadir
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pizzas p = new Pizzas();

                p.setId(UUID.randomUUID().toString());
                p.setNombre(nom.getText().toString());
                p.setPrecio(precio.getText().toString());
                p.setLocalizacion(loc.getText().toString());

                databaseReference.child("Pizzas").child(p.getId()).setValue(p);
                Toast.makeText(getBaseContext(),"Has añadido una Pizza", Toast.LENGTH_LONG).show();
            }
        });

    }

    //Método para obtener mi database
    public void obtenerDataBase()
    {
        FirebaseApp.initializeApp(this); //inicia database
        firebase = FirebaseDatabase.getInstance(); //Obtengo instancia
        databaseReference = firebase.getReference(); //Obtengo referencia
    }

}