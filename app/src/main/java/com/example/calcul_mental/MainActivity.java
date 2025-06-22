package com.example.calcul_mental;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button btnFr;
    private Button btnEn;
    private Button btnInfo;  // bouton À propos

    private Locale currentLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boutonJouer = findViewById(R.id.btnJouer);
        btnFr = findViewById(R.id.btnFr);
        btnEn = findViewById(R.id.btnEn);
        btnInfo = findViewById(R.id.btnInfo); // liaison bouton À propos

        btnFr.setOnClickListener(v -> {
            setLocale("fr");
            Toast.makeText(MainActivity.this, "Langue : Français", Toast.LENGTH_SHORT).show();
        });

        btnEn.setOnClickListener(v -> {
            setLocale("en");
            Toast.makeText(MainActivity.this, "Language: English", Toast.LENGTH_SHORT).show();
        });

        boutonJouer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculMentalActivity.class);
            startActivity(intent);
        });

        btnInfo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AProposActivity.class);
            startActivity(intent);
        });
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);

        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        recreate();
    }
}
