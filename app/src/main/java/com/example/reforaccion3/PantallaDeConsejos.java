package com.example.reforaccion3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PantallaDeConsejos extends AppCompatActivity {

    private EditText etTipsContent;
    private Button btnSave;
    private Button btnBack;
    private Button btnChangeBackground;
    private SharedPreferences sharedPreferences;
    private ConstraintLayout mainLayout;
    private int currentBackgroundIndex = 0;
    private int[] backgrounds = {R.drawable.diadelarbol, R.drawable.landscape_3776968, R.drawable.plantar_arbol_dia}; // Asegúrate de tener estos drawables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_consejos);

        // Inicializar vistas
        etTipsContent = findViewById(R.id.etTipsContent);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);
        btnChangeBackground = findViewById(R.id.btnChangeBackground);
        mainLayout = findViewById(R.id.mainLayout);

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("TipsPrefs", MODE_PRIVATE);

        // Cargar consejos guardados
        String savedTips = sharedPreferences.getString("tips", "");
        etTipsContent.setText(savedTips);

        // Configurar listener para el botón de guardar
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tips = etTipsContent.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tips", tips);
                editor.apply();
                Toast.makeText(PantallaDeConsejos.this, "Tips saved", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar listener para el botón de retroceso
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Configurar listener para el botón de cambiar fondo
        btnChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackground();
            }
        });
    }

    private void changeBackground() {
        currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
        mainLayout.setBackgroundResource(backgrounds[currentBackgroundIndex]);
    }
}