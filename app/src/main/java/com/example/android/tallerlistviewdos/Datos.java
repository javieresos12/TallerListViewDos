package com.example.android.tallerlistviewdos;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Celular> celular = new ArrayList<>();

    public static void guardar (Celular ce){
        celular.add(ce);
    }

    public static ArrayList<Celular>obtener (){
        return celular;
    }
}
