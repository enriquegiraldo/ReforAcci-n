package com.example.reforaccion3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BaseActivity extends AppCompatActivity {

    protected ConstraintLayout mainLayout;
    protected SharedPreferences sharedPreferences;
    private int[] backgrounds = {R.drawable.diadelarbol, R.drawable.deforestacion, R.drawable.granjero_plantar_un_arbol, R.drawable.plantar_arbol_dia, R.drawable.landscape_3776968}; // Asegúrate de tener estos drawables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mainLayout = findViewById(R.id.mainLayout);
        applyCurrentBackground();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_background) {
            changeBackground();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeBackground() {
        int currentBackgroundIndex = sharedPreferences.getInt("backgroundIndex", 0);
        currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
        sharedPreferences.edit().putInt("backgroundIndex", currentBackgroundIndex).apply();
        applyCurrentBackground();
    }

    private void applyCurrentBackground() {
        if (mainLayout != null) {
            int currentBackgroundIndex = sharedPreferences.getInt("backgroundIndex", 0);
            mainLayout.setBackgroundResource(backgrounds[currentBackgroundIndex]);
        }
    }
}