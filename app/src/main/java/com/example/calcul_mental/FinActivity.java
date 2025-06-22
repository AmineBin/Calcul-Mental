package com.example.calcul_mental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin); // Le layout qui contient ton écran de fin

        TextView fin = findViewById(R.id.fin); // Doit exister dans activity_fin.xml
        int score = getIntent().getIntExtra("SCORE", 0);
        fin.setText(" " + score + " "); // Affiche le score

        Button btnAccueil = findViewById(R.id.btnAccueil); // Facultatif
        btnAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(FinActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
