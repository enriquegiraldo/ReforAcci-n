package com.example.reforaccion3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaDeInicioDeSesion extends BaseActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_inicio_de_sesion);

        // Inicializar vistas
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        btnBack = findViewById(R.id.btnBack);

        // Configurar el listener del botón de inicio de sesión
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (isValidCredentials(email, password)) {
                    // Aquí iría la lógica para iniciar sesión
                    Toast.makeText(PantallaDeInicioDeSesion.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PantallaDeInicioDeSesion.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el listener del texto de registro
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la pantalla de registro de usuarios
                Intent intent = new Intent(PantallaDeInicioDeSesion.this, RegistroDeUsuarios.class);
                startActivity(intent);
            }
        });

        // Configurar el listener del botón de volver
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean isValidCredentials(String email, String password) {
        // Aquí deberías implementar la lógica real de validación
        // Este es solo un ejemplo simple
        return !email.isEmpty() && !password.isEmpty();
    }
}