package com.example.gautiercouvrat.persistancebd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BDLivres bdLivres;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdLivres = new BDLivres(this);
    }

    public void ajouter(View view){
        EditText isbn = (EditText) findViewById(R.id.editIsbn);
        EditText titre = (EditText) findViewById(R.id.editTitre);

        Log.d(TAG, "ajouter : ISBN = "+ isbn.getText().toString());
        Log.d(TAG, "ajouter : Titre = "+ titre.getText().toString());

        bdLivres.open();
        bdLivres.insertLivre(new Livre(isbn.getText().toString(), titre.getText().toString()));
        bdLivres.close();

        isbn.setText("");
        titre.setText("");
    }


    public void rechercher(View view){
        EditText titre = (EditText) findViewById(R.id.editRecherche);

            Livre res = bdLivres.getLivreByTitre(titre.getText().toString());

            if(res == null){
                Log.e(TAG, "rechercher --> la recherche de "+titre + " ne ramène aucun résultat");
                Toast.makeText(this, "La recherche de "+titre + " ne ramène aucun résultat",Toast.LENGTH_SHORT);
            }

            //création de l'intent
            Intent intent = new Intent(this, AfficherResultat.class);

            //ajoute les infos
            intent.putExtra("isbn", res.getIsbn());
            intent.putExtra("titre",res.getTitre());

            //lance l'activité
            startActivity(intent);

            titre.setText("");
    }


}
