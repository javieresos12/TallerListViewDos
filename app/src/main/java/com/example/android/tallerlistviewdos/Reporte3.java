package com.example.android.tallerlistviewdos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte3 extends Activity {
    private TableLayout tabla;
    private ArrayList<Celular> celu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte3);
        tabla = findViewById(R.id.tabla);
        celu= Datos.obtener();
          String marca;
          int capacidad, j=1;
        for (int i = 0; i <celu.size() ; i++) {
            marca= celu.get(i).getMarca().toString();
            capacidad= celu.get(i).getCapacidad();
            if (marca.equalsIgnoreCase("samsung") && (capacidad>=2 && capacidad<=4)) {

                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);
                TextView c4 = new TextView(this);
                TextView c5 = new TextView(this);
                TextView c6 = new TextView(this);

                c1.setText("" + (j++));
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
}
