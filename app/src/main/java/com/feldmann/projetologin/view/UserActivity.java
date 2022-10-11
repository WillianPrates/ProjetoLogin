package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.ListsPresenter;
import com.feldmann.projetologin.presenter.LoginPresenter;
import com.feldmann.projetologin.presenter.PresenterContract;
import com.feldmann.projetologin.repository.DBHelper;

public class UserActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "UserActivity";
    private PresenterContract.presenterLists presenterLists;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);
        //
        DBHelper db = new DBHelper(this, this);
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        getUsersDB(sqlDB);
        //
        presenterLists.setAdapterRVUsers( (RecyclerView) findViewById(R.id.RVUsers));
        //
    }
    //
    public void getUsersDB(SQLiteDatabase sql){
        Log.d(tagLog, "getUsersDB");
        Cursor cursor = sql.rawQuery("SELECT * FROM usuarios", null);
        if (cursor.moveToFirst()) {
            Log.d("getUsersDB", "tem registros no banco");
            do {
                //
                Log.d("getUsersDB",
                        "\nID: "+cursor.getString(0)+
                                "\nNome: "+cursor.getString(1)+
                                "\nLogin: "+cursor.getString(2)+
                                "\nSenha: "+cursor.getString(3) );
            } while (cursor.moveToNext());
        }else{
            Log.d("getUsersDB", "não tem registros");
        }
        cursor.close();
    }
    //
    @Override
    public void message(String msg) { /**/ }
    @Override
    public Activity getActivity() { return this; }
}