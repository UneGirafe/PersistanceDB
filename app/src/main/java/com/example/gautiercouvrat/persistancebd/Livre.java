package com.example.gautiercouvrat.persistancebd;

import android.util.Log;

/**
 * Created by gautiercouvrat on 30/11/2016.
 */

public class Livre {

    private static final String TAG = "Livre";
    private int id;
    private String isbn;
    private String titre;


    //constructeur par défaut : appelé pour instancier des collections de Livre
    public Livre (){

    }

    public Livre (String pIsbn, String pTitre){
        isbn  = pIsbn;
        titre = pTitre;
        Log.v(TAG, "Livre créé : "+isbn+", "+titre);
    }

    public Livre(int pId, String pIsbn, String pTitre){
        id = pId;
        isbn  = pIsbn;
        titre = pTitre;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
