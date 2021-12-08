package com.example.pizzeriafb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Models.Ingredientes;
import Models.MenuPizzas;

public class Arma_pizza_act extends AppCompatActivity {

    private Spinner tipoPizza, ingrediente;
    private TextView result, total;

    private Ingredientes ing = new Ingredientes();
    private MenuPizzas mp = new MenuPizzas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        tipoPizza = findViewById(R.id.spPizza);
        ingrediente = findViewById(R.id.spIngred);
        result = findViewById(R.id.result);
        total = findViewById(R.id.total);

        //Listas
        String[] listaPizzas = mp.getTipoPizza();
        String[] listaIngre = ing.getNombreIngr();

        //Creo ArrayAdapter
        ArrayAdapter adaptPizza = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaPizzas);
        ArrayAdapter adaptIngre = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaIngre);

        //Pasar adaptadores a spinners
        tipoPizza.setAdapter(adaptPizza);
        ingrediente.setAdapter(adaptIngre);
    }

    //Método para calcular insumos
    @SuppressLint("SetTextI18n")
    public void Calcular(View view){

        String opcionPizza = tipoPizza.getSelectedItem().toString();//Obtener lo seleccionado
        String opcionIngred = ingrediente.getSelectedItem().toString();
        int precioFinal = 0;
        int adicional = 0;

        //Recorre las opciones
        for(int a = 0; a < opcionIngred.length(); a++) //(declaración, condición, incremento)
        {
            if(opcionIngred.equals(ing.getNombreIngr()[a]))
            {
                adicional = ing.getValorIng()[a];
                break;
            }
        }

        for(int i = 0; i < opcionPizza.length(); i++) //(declaración, condición, incremento)
        {
            if(opcionPizza.equals(mp.getTipoPizza()[i]))
            {
                precioFinal = mp.anadirAdicional(mp.getPrecioPizza()[i],adicional);
                break;
            }
        }
        result.setText(opcionPizza + "\n con " + opcionIngred);
        total.setText("$" + precioFinal);
    }

}