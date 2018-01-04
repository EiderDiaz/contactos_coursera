package com.example.eider.contactos;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.support.design.widget.TextInputEditText fecha,nombre,telefono;
    EditText descripcion;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fecha = ( android.support.design.widget.TextInputEditText)findViewById(R.id.tvfecha);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modalFecha();
            }
        });
        nombre = ( android.support.design.widget.TextInputEditText)findViewById(R.id.tvnombre);
        telefono =  ( android.support.design.widget.TextInputEditText)findViewById(R.id.tvtelefono);
        descripcion = (EditText) findViewById(R.id.tvdescripcion);
        button =  (Button) findViewById(R.id.button_siguiente);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Confirmar_datos.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("fecha",fecha.getText().toString());
                intent.putExtra("telefono",telefono.getText().toString());
                intent.putExtra("descripcion",descripcion.getText().toString());
                startActivity(intent);
                finish();

            }
        });
        llenarDatosIntent();
    }

    private void llenarDatosIntent() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombre.setText(getIntent().getExtras().getString("nombre"));
            fecha.setText(getIntent().getExtras().getString("fecha"));
            telefono.setText(getIntent().getExtras().getString("telefono"));
            descripcion.setText(getIntent().getExtras().getString("descripcion"));
        }

    }
    public void modalFecha() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.date_dialog, null);
        dialogBuilder.setView(dialogView);
        final TextView titulo = (TextView) dialogView.findViewById(R.id.better_dialog_titulo);
        final DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker);
        titulo.setText("selecciona la fecha ");
        titulo.setTextSize(28);
        final TextView mensaje = (TextView) dialogView.findViewById(R.id.better_dialog_mensaje);
        mensaje.setText("selecciona la fecha ");
       /* dialogBuilder.setPositiveButton("Terminar vuelo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                terminarVuelo(edt.getText().toString());
            }
        });*/
        final  AlertDialog b = dialogBuilder.create();
        b.show();
        final  TextView aceptar = (TextView) dialogView.findViewById(R.id.better_dialog_aceptar);
        aceptar.setText("Acpetar");
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.dismiss();
                int   day  = datePicker.getDayOfMonth();
                int   month= datePicker.getMonth()+1;
                int   year = datePicker.getYear();
                Toast.makeText(MainActivity.this, day+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
                fecha.setText(day+"/"+month+"/"+year);

            }
        });
        final  TextView cancelar = (TextView) dialogView.findViewById(R.id.better_dialog_cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.dismiss();
            }
        });

    }
}
