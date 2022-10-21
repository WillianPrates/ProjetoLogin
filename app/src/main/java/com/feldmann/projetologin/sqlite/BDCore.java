package com.feldmann.projetologin.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "teste";
    private static final int VERSAO_BD = 1;


    public BDCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table usuario;");
        onCreate(sqLiteDatabase);
    }
}
