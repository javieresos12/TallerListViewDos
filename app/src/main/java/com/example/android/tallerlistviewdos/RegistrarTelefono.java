package com.example.android.tallerlistviewdos;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarTelefono extends Activity {
    private Spinner marca, color, sistemaoperativo;
    private EditText capacidad, precio;
    private Resources recursos;
    private String op[];
    private String op2[];
    private String op3[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_telefono);

        marca= findViewById(R.id.cmbMarca);
        color= findViewById(R.id.cmbColor);
        sistemaoperativo = findViewById(R.id.cmbSistemaOperativo);
        capacidad= findViewById(R.id.txtcapacidadRam);
        precio = findViewById(R.id.txtprecio);

        recursos= this.getResources();

        op= recursos.getStringArray(R.array.Idmarca);
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, op);
        marca.setAdapter(adapter);

        op2= recursos.getStringArray(R.array.Idcolor);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, op2);
        color.setAdapter(adapter2);

        op3= recursos.getStringArray(R.array.IdSistemaOperativo);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, op3);
        sistemaoperativo.setAdapter(adapter3);

    }

    public void Guardar (View v) {
        String marca2, color2, sistema2;
        double precio2;
        int capacidad2;

        if (validar()) {
            marca2 = marca.getSelectedItem().toString();
            color2 = color.getSelectedItem().toString();
            sistema2 = sistemaoperativo.getSelectedItem().toString();
            capacidad2 = Integer.parseInt(capacidad.getText().toString());
            precio2 = Double.parseDouble(precio.getText().toString());

            Celular cel = new Celular(marca2, color2, sistema2, capacidad2, precio2);
            cel.guardar();
            Toast.makeText(this, getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();

        }
    }


    public boolean validar(){

        if (marca.getSelectedItemPosition()==0){
            Toast.makeText(this, R.string.errorReporte1, Toast.LENGTH_SHORT).show();
            marca.requestFocus();
            return false;
        }
        if (color.getSelectedItemPosition()==0){
            Toast.makeText(this, R.string.errorReporte2, Toast.LENGTH_SHORT).show();
            color.requestFocus();
            return false;
        }
        if (sistemaoperativo.getSelectedItemPosition()==0){
            Toast.makeText(this, R.string.errorReporte3, Toast.LENGTH_SHORT).show();
            sistemaoperativo.requestFocus();
            return false;
        }
        if (capacidad.getText().toString().isEmpty()){
            capacidad.setError(recursos.getString(R.string.errorReporte4));
            capacidad.requestFocus();
            return false;
        }
        if (precio.getText().toString().isEmpty()){
            precio.setError(recursos.getString(R.string.errorReporte5));
            precio.requestFocus();
            return false;
        }

        return true;
    }

    public void limpiar(View v){
        borrar();
    }

    public void borrar(){
        marca.setSelection(0);
        color.setSelection(0);
        sistemaoperativo.setSelection(0);
        precio.setText("");
        capacidad.setText("");
        marca.requestFocus();


    }

}
