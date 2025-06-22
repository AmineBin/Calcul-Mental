package com.example.calcul_mental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AProposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);

        Button btnAccueil = findViewById(R.id.btnAccueil);
        btnAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(AProposActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

