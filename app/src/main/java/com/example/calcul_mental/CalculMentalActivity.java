package com.example.calcul_mental;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;
import androidx.activity.EdgeToEdge;

import android.content.Intent;

import java.util.Random;

public class CalculMentalActivity extends AppCompatActivity {

    private Integer PremierElem;
    private Integer DeuxiemeElem;
    private Integer resultat;
    private TypeOperation typeoperation;

    private TextView PremierChiffre;
    private TextView SecondChiffre;
    private TextView Operateur;
    private EditText editTextNumber;
    private Button btnJouer;

    private TextView textViewScore;
    private TextView textViewVies;

    private int score = 0;
    private int vies = 3;

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

        // Liaisons avec le layout
        PremierChiffre = findViewById(R.id.premierChiffre);
        SecondChiffre = findViewById(R.id.secondChiffre);
        Operateur = findViewById(R.id.operateur);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnJouer = findViewById(R.id.btnJouer);
        textViewScore = findViewById(R.id.textViewScore);
        textViewVies = findViewById(R.id.textViewVies);

        // Génération d’une première opération
        Valeur();
        afficherOperation();
        updateStats();

        // Quand on appuie sur le bouton
        btnJouer.setOnClickListener(v -> {
            String reponseTexte = editTextNumber.getText().toString();

            if (!reponseTexte.isEmpty()) {
                try {
                    int reponseUtilisateur = Integer.parseInt(reponseTexte);

                    if (reponseUtilisateur == resultat) {
                        score++;
                        editTextNumber.setError(null);
                        editTextNumber.setText("");
                        updateStats();
                        Valeur();
                        afficherOperation();
                    } else {
                        vies--;
                        updateStats();

                        if (vies <= 0) {
                            Intent intent = new Intent(CalculMentalActivity.this, FinActivity.class);
                            intent.putExtra("SCORE", score);
                            startActivity(intent);
                            finish();
                        } else {
                            editTextNumber.setError("Mauvaise réponse !");
                        }
                    }
                } catch (NumberFormatException e) {
                    editTextNumber.setError("Entrée invalide");
                }
            } else {
                editTextNumber.setError("Veuillez entrer une réponse");
            }
        });
    }

    // Génère une opération aléatoire
    protected void Valeur() {
        Random random = new Random();

        PremierElem = random.nextInt(100);
        DeuxiemeElem = random.nextInt(100);

        int nb = 1 + random.nextInt(4); // 1 à 4

        switch (nb) {
            case 1:
                resultat = PremierElem + DeuxiemeElem;
                typeoperation = TypeOperation.PLUS;
                break;
            case 2:
                resultat = PremierElem - DeuxiemeElem;
                typeoperation = TypeOperation.MOIN;
                break;
            case 3:
                while (DeuxiemeElem == 0) {
                    DeuxiemeElem = random.nextInt(100);
                }
                resultat = PremierElem / DeuxiemeElem;
                typeoperation = TypeOperation.DIVISER;
                break;
            case 4:
                resultat = PremierElem * DeuxiemeElem;
                typeoperation = TypeOperation.MULTIPLIER;
                break;
        }
    }

    // Affiche l’opération sur les TextView
    private void afficherOperation() {
        PremierChiffre.setText(String.valueOf(PremierElem));
        SecondChiffre.setText(String.valueOf(DeuxiemeElem));
        Operateur.setText(typeoperation.getSymbole());
    }

    // Met à jour l’affichage du score et des vies
    private void updateStats() {
        textViewScore.setText("Score : " + score);
        textViewVies.setText("Vies : " + vies);
    }


}
