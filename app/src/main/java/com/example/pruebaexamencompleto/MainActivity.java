package com.example.pruebaexamencompleto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textView;
    private Button bSumar,
            bRestar,
            bReset;

    List<String> operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
        bSumar = findViewById(R.id.bSumar);
        bReset = findViewById(R.id.bReset);
        bRestar = findViewById(R.id.bRestar);

        operaciones = new ArrayList<>();
        operaciones.add("SUMAR");
        operaciones.add("RESTAR");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, operaciones);
        spinner.setAdapter(myAdapter);

        textView.setText("0");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    bSumar.setVisibility(View.VISIBLE);
                    bRestar.setVisibility(View.GONE);
                }else if (i == 1) {
                    bRestar.setVisibility(View.VISIBLE);
                    bSumar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        bSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = textView.getText().toString();
                int aux = Integer.parseInt(num);
                textView.setText(suma(aux) + "");
            }
        });

        bRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = textView.getText().toString();
                int aux = Integer.parseInt(num);
                textView.setText(resta(aux) + "");
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
            }
        });
    }

    private int suma(int i){
        i++;
        return i;
    }

    private int resta(int i){
        i--;
        return i;
    }
}