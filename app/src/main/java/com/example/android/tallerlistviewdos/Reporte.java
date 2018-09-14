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
               opcionR= reporte.getSelectedItemPosition();
               switch (opcionR) {

                   case 1:
                       in = new Intent(Reporte.this, Reporte3.class);
                       startActivity(in);
                       break;

                   case 2:
                      cantidad=Metodos.numeroCelulares(celular);
                      datos2=getResources().getString(R.string.cantidad)+String.valueOf(cantidad);
                       AlertDialog.Builder builder = new AlertDialog.Builder(this);
                       builder.setTitle(R.string.reporte4);
                       builder.setMessage(datos2);
                       builder.setNeutralButton("Ok", null);
                       Dialog dialog = builder.create();
                       dialog.show();
                       break;

                   case 3:
                    promedio = Metodos.promediocelulares(celular);
                    datos= getResources().getString(R.string.promedio)+String.valueOf(promedio);

                       AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                       builder2.setTitle(R.string.reporte5);
                       builder2.setMessage(datos);
                       builder2.setNeutralButton("Ok", null);
                       Dialog dialog2 = builder2.create();
                       dialog2.show();
                       break;
               }

            }
        /*
        * public void resultado(View v){
        if (validar()) {
            double lad, res;
            String op, dat, dec;
            lad = Double.parseDouble(txtLados.getText().toString());
            res = Metodos.areaCuadrado(lad);
            //Respuesta con dos cifras decimales
            dec = String.valueOf(String.format("%.2f", res));

            //Crear objeto y guardarlo en datos
            op = getResources().getString(R.string.areaCuadrado);
            dat = getResources().getString(R.string.lado) + String.valueOf(lad);
            Operacion o = new Operacion(op, dat, dec);
            o.guardar();

            //Mostrar resultado en dialogo
            String mensaje = getResources().getString(R.string.area) + " " + dec;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.resultado);
            builder.setMessage(mensaje);
            builder.setNeutralButton("Ok", null);
            Dialog dialog = builder.create();
            dialog.show();
        }
    }*/
    }

