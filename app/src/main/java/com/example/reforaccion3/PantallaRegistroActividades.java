package com.example.reforaccion3;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PantallaRegistroActividades extends BaseActivity {

    private EditText etLocation, etTreeType, etQuantity, etDate;
    private Button btnSubmit, btnBack;
    private Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_registro_de_actividades);

        // Initialize views for activity registration
        etLocation = findViewById(R.id.etLocation);
        etTreeType = findViewById(R.id.etTreeType);
        etQuantity = findViewById(R.id.etQuantity);
        etDate = findViewById(R.id.etDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnBack = findViewById(R.id.btnBack);

        myCalendar = Calendar.getInstance();

        // Configure date picker
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PantallaRegistroActividades.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Configure submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Logic to save data goes here
                    Toast.makeText(PantallaRegistroActividades.this, "Actividad registrada con éxito", Toast.LENGTH_SHORT).show();
                    clearInputs();
                }
            }
        });

        // Configure back button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etDate.setText(sdf.format(myCalendar.getTime()));
    }

    private boolean validateInputs() {
        if (etLocation.getText().toString().trim().isEmpty() ||
                etTreeType.getText().toString().trim().isEmpty() ||
                etQuantity.getText().toString().trim().isEmpty() ||
                etDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void clearInputs() {
        etLocation.setText("");
        etTreeType.setText("");
        etQuantity.setText("");
        etDate.setText("");
    }
}