package com.example.reforaccion3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaDeEstadisticas extends BaseActivity {

    private TextView tvTitle;
    private TextView tvTotalTrees;
    private TextView tvTotalCO2;
    private TextView tvProgress;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_estadisticas);

        // Inicializar vistas
        tvTitle = findViewById(R.id.tvTitle);
        tvTotalTrees = findViewById(R.id.tvTotalTrees);
        tvTotalCO2 = findViewById(R.id.tvTotalCO2);
        tvProgress = findViewById(R.id.tvProgress);
        btnBack = findViewById(R.id.btnBack);

        // Configurar datos (esto es un ejemplo, deberías obtener datos reales)
        tvTotalTrees.setText(getString(R.string.total_trees) + " 1000");
        tvTotalCO2.setText(getString(R.string.total_co2) + " 500 kg");
        tvProgress.setText(getString(R.string.general_progress) + " 75%");

        // Configurar listener para el botón de retroceso
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta actividad y vuelve a la anterior
            }
        });
    }
}