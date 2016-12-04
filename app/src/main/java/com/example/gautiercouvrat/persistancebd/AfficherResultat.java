package com.example.gautiercouvrat.persistancebd;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;

public class AfficherResultat extends Activity {

    private EditText isbn = (EditText) findViewById(R.id.isbnResult);
    private EditText titre = (EditText) findViewById(R.id.titreResult);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_resultat);

        //récupère l'intent appelant
        Intent intent = getIntent();

        //récupère les valeurs
        isbn.setText(intent.getStringExtra("isbn"));
        titre.setText(intent.getStringExtra("titre"));

    }
}
