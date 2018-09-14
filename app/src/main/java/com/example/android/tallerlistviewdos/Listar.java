package com.example.android.tallerlistviewdos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Listar extends Activity {
    private TableLayout tabla;
    private ArrayList<Celular> celu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        tabla = findViewById(R.id.tabla);
        celu= Datos.obtener();

        for (int i = 0; i <celu.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(celu.get(i).getMarca());
            c3.setText(celu.get(i).getColor());
            c4.setText(celu.get(i).getSistema_operativo());
            c5.setText(String.valueOf(celu.get(i).getCapacidad()));
            c6.setText(String.valueOf(celu.get(i).getPrecio()));

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);

            tabla.addView(fila);
        }
    }
}
