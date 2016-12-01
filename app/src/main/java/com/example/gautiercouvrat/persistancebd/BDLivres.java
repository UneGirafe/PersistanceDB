package com.example.gautiercouvrat.persistancebd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gautiercouvrat on 30/11/2016.
 */

public class BDLivres {
    private final int VERSION_BDD = 1;
    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;


    public BDLivres(Context context){
//On crée la BDD et sa table :
        maBaseSQLite = new MaBaseSQLite(context,"livres",null,VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public long insertLivre(Livre livre){
        //Création d'un ContentValues (fonctionne comme une HashMap : clé, valeur)
        ContentValues values = new ContentValues();
        values.put("isbn",livre.getIsbn());
        values.put("titre",livre.getTitre());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert("Livre",null,values);
    }

    public Livre getLivreByTitre(String titre){
        Cursor cursor = bdd.query("Livre",new String[]{"id","isbn","titre"},"titre like \""+
        titre + "\"" ,null,null,null,null,null);

        return cursorToLivre(cursor);
    }

    private Livre cursorToLivre (Cursor cursor){
        if ( cursor.getCount() == 0 ) return null;

        cursor.moveToFirst();
        Livre livre = new Livre();
        livre.setId(cursor.getInt(0));
        livre.setIsbn(cursor.getString(1));
        livre.setTitre(cursor.getString(2));
        cursor.close();
        return livre;
    }
}
