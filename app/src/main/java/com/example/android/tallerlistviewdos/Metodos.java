package com.example.android.tallerlistviewdos;

import java.util.ArrayList;

public class Metodos {


    public static  double promediocelulares (ArrayList<Celular> celular){
        double suma=0, promedio;

        for (int i = 0; i <celular.size() ; i++) {
            if (celular.get(i).getMarca().equalsIgnoreCase("Nokia")) {
                suma = suma + celular.get(i).getPrecio();
            }
        }
         promedio=suma/(celular.size());

        return  promedio;
    }
}
