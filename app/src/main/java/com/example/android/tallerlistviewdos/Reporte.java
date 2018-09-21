package com.example.android.tallerlistviewdos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Reporte extends Activity {
     private Spinner reporte;
     private Resources recursos;
     private String op[];
     private ArrayList celular;
    private Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        reporte = findViewById(R.id.cmbReporte);
        celular = Datos.obtener();
        recursos = this.getResources();

        op = recursos.getStringArray(R.array.Idreporte);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, op);
        reporte.setAdapter(adapter);

    }
           public void resultado(View v){
               int opcionR, cantidad;
               double promedio;
               String datos, datos2;

               if (validar()) {
                   opcionR = reporte.getSelectedItemPosition();
                   switch (opcionR) {

                       case 1:
                           in = new Intent(Reporte.this, Reporte3.class);
                           startActivity(in);
                           break;

                       case 2:
                           cantidad = Metodos.numeroCelulares(celular);
                           datos2 = getResources().getString(R.string.cantidad) + String.valueOf(cantidad);
                           AlertDialog.Builder builder = new AlertDialog.Builder(this);
                           builder.setTitle(R.string.reporte4);
                           builder.setMessage(datos2);
                           builder.setNeutralButton("Ok", null);
                           Dialog dialog = builder.create();
                           dialog.show();
                           break;

                       case 3:
                           promedio = Metodos.promediocelulares(celular);
                           datos = getResources().getString(R.string.promedio) + String.valueOf(promedio);

                           AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                           builder2.setTitle(R.string.reporte5);
                           builder2.setMessage(datos);
                           builder2.setNeutralButton("Ok", null);
                           Dialog dialog2 = builder2.create();
                           dialog2.show();
                           break;
                   }
               }

            }

            public boolean validar(){

             if (reporte.getSelectedItemPosition()==0) {
                 Toast.makeText(this, R.string.errorReporte, Toast.LENGTH_SHORT).show();
                 reporte.requestFocus();
                 return false;
             }

             return true;
            }


            public void limpiar(View v){
             borrar();
            }

            public void borrar (){
             reporte.setSelection(0);
            }


    }

