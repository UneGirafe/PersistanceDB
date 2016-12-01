package com.example.gautiercouvrat.persistancebd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gautiercouvrat on 30/11/2016.
 */

public class MaBaseSQLite extends SQLiteOpenHelper {

    private final static String CREATE_TABLE ="create table Livre("+
            "id INTEGER PRIMARY KEY   AUTOINCREMENT, "+
            "isbn text not null,"+
            "titre text not null"+
            ");"
            ;


    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE Livre");
        db.execSQL(CREATE_TABLE);
    }
}
