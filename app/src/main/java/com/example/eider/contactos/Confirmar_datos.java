package com.example.eider.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar_datos extends AppCompatActivity {
        TextView nombre,fecha,telefono,descripcion;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        nombre = (TextView)findViewById(R.id.nombre);
        fecha = (TextView)findViewById(R.id.fecha_nacimiento);
        telefono = (TextView)findViewById(R.id.telefono);
        descripcion = (TextView)findViewById(R.id.descripcion);
        button = (Button) findViewById(R.id.editar_datos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
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
}
