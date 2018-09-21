package com.example.android.tallerlistviewdos;

import java.util.ArrayList;

public class Metodos {


    public static  double promediocelulares (ArrayList<Celular> celular){
        double suma=0, promedio=0;
        int contador=0;

        for (int i = 0; i <celular.size() ; i++) {
            if (celular.get(i).getMarca().equalsIgnoreCase("Nokia")) {
                suma = suma + celular.get(i).getPrecio();
                contador++;
            }
        }
         promedio=suma/contador;

        return  promedio;
    }

    public static int numeroCelulares (ArrayList<Celular> celular){
     int cantidad=0;
     String marca, color;

        for (int i = 0; i <celular.size() ; i++) {
            marca= celular.get(i).getMarca().toString();
            color=celular.get(i).getColor().toString();
            if (marca.equalsIgnoreCase("Apple") && color.equalsIgnoreCase("negro")){
                cantidad++;
            }
        }
        return cantidad;
    }
}
