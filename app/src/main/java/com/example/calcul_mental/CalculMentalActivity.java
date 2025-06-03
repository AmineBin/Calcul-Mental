package com.example.calcul_mental;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class CalculMentalActivity extends AppCompatActivity {
    private Integer PremierElem;
    private Integer DeuxiemeElem;
    private Integer resultat;
    private TypeOperation typeoperation;


    protected void Valeur() {
        Random random = new Random();

        this.PremierElem = random.nextInt(100);
        this.DeuxiemeElem = random.nextInt(100);

        int nb = 1 + random.nextInt(4); // génère 1 à 4 inclus

        switch (nb) {
            case 1:
                this.resultat = PremierElem + DeuxiemeElem;
                this.typeoperation=TypeOperation.PLUS;
                break;
            case 2:
                this.resultat = PremierElem - DeuxiemeElem;
                this.typeoperation=TypeOperation.MOIN;
                break;
            case 3:
                while(DeuxiemeElem == 0){
                    this.DeuxiemeElem = random.nextInt(100);
                }
                this.resultat = PremierElem / DeuxiemeElem;
                this.typeoperation=TypeOperation.DIVISER;
                break;
            case 4:
                this.resultat = PremierElem * DeuxiemeElem;
                this.typeoperation=TypeOperation.MULTIPLIER;
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jeu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
