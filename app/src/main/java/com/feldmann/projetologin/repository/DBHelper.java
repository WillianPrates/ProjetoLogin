package com.feldmann.projetologin.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.feldmann.projetologin.presenter.PresenterContract;

public class DBHelper extends SQLiteOpenHelper {
    //
    private static final String tagLog = "DBHelper";
    private static final String NOME_BANCO = "app.db";
    private static final int VERSAO_BANCO = 1;
    //
    private PresenterContract.presenterDB presenterDB;
    //
    public DBHelper(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        Log.d(tagLog, "Contructor");
    }
    //
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(tagLog, "onCreate");
        //
        db.execSQL( presenterDB.criarTabelaUser() );
    }
    //
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(tagLog, "onUpgrade");
        //
    }
    //
}
