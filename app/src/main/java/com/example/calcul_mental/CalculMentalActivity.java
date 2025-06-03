package com.example.calcul_mental;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Random;


public class CalculMentalActivity {
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
                resultat = PremierElem + DeuxiemeElem;
                typeoperation=TypeOperation.PLUS;
                break;
            case 2:
                resultat = PremierElem - DeuxiemeElem;
                typeoperation=TypeOperation.MOIN;
                break;
            case 3:
                while(DeuxiemeElem == 0){
                    this.DeuxiemeElem = random.nextInt(100);
                }
                resultat = PremierElem / DeuxiemeElem;
                typeoperation=TypeOperation.DIVISER;
                break;
            case 4:
                resultat = PremierElem * DeuxiemeElem;
                typeoperation=TypeOperation.MULTIPLIER;
                break;
        }
    }
}
