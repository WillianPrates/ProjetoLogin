package com.feldmann.projetologin.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.feldmann.projetologin.model.User;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private SQLiteDatabase sqLiteDatabase;

    public Banco(Context context){
        BDCore auxBD = new BDCore(context);
        sqLiteDatabase = auxBD.getWritableDatabase();
    }

    public void inserir(User user){
        ContentValues values = new ContentValues();
        values.put("nome", user.getNome());
        values.put("email", user.getLogin());
        values.put("senha", user.getSenha());

        sqLiteDatabase.insert("usuario", null, values);
    }

    public void atualizar(User user){
        ContentValues values = new ContentValues();
        values.put("nome", user.getNome());
        values.put("email", user.getLogin());

        sqLiteDatabase.update("usuario", values, "_id = ?", new String[]{""+user.getId()});
    }

    public void deletar(User user){

        sqLiteDatabase.delete("usuario", "_id = " + + user.getId(), null);
    }

    public List<User> buscar(User user){

        List<User> list = new ArrayList<User>();

        String[] colunas = new String[]{"_id", "nome", "email"};
        Cursor cursor = sqLiteDatabase.query("usuario", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0){
            cursor.moveToFirst();

            do {

                User u = new User();
                user.setId((int) cursor.getLong(0));
                user.setNome(cursor.getString(1));
                user.setLogin(cursor.getString(2));
                list.add(u);

            }while (cursor.moveToNext());
        }

        return (list);
    }



}
