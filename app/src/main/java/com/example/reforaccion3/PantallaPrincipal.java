package com.example.reforaccion3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaPrincipal extends BaseActivity {

    private TextView tvWelcome;
    private Button btnRegister, btnStatistics, btnTips, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);

        // Inicializar vistas
        tvWelcome = findViewById(R.id.tvWelcome);
        btnRegister = findViewById(R.id.btnRegister);
        btnStatistics = findViewById(R.id.btnStatistics);
        btnTips = findViewById(R.id.btnTips);
        btnLogin = findViewById(R.id.btnLogin);

        // Configurar listeners para los botones
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaPrincipal.this, PantallaRegistroActividades.class);
                startActivity(intent);
            }
        });

        btnStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaPrincipal.this, PantallaDeEstadisticas.class);
                startActivity(intent);
            }
        });

        btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaPrincipal.this, PantallaDeConsejos.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaPrincipal.this, PantallaDeInicioDeSesion.class);
                startActivity(intent);
            }
        });
    }
}