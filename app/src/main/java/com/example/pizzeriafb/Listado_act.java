package com.example.pizzeriafb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Models.Pizzas;

public class Listado_act extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Pizzas> listaPizzas = new ArrayList<>();

    Pizzas pizzaSelected; //declaro para guardar opción elegida

    //declaro variables para obtener mi database
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.lv);

        obtenerDataBase();

        //Método para obtener la selección del ListView
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                pizzaSelected = (Pizzas) parent.getItemAtPosition(position); //guardo la posición
            }
        });

        // MOSTRAR pizzas
        databaseReference.child("Pizzas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //Obtiene los valores de la entrada en tiempo real
                for(DataSnapshot op: snapshot.getChildren()) //recorrer
                {
                    Pizzas p = op.getValue(Pizzas.class);

                    listaPizzas.add(p); //añade objeto al arreglo

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaPizzas);

                    lista.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                //Avisa si hubo algún error en la databse

            }
        });



    }
    //Método para eliminar de la database
    public void Eliminar(View view){
        Pizzas p = new Pizzas();
        p.setId(pizzaSelected.getId());

        //elimina de la database según la comparación del id
        databaseReference.child("Pizzas").child(p.getId()).removeValue();
        Toast.makeText(getBaseContext(),"Se ha eliminado de la base de datos", Toast.LENGTH_LONG).show();
    }

    //Método para obtener mi database
    public void obtenerDataBase()
    {
        FirebaseApp.initializeApp(this); //inicia database
        firebase = FirebaseDatabase.getInstance(); //Obtengo instancia
        databaseReference = firebase.getReference(); //Obtengo referencia
    }
}