package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.PresenterContract;
import com.feldmann.projetologin.presenter.SplashPresenter;
import com.feldmann.projetologin.repository.DBHelper;

public class SplashScreenActivity extends AppCompatActivity implements PresenterContract.view {
    private static final String tagLog = "SplashScreen";
    private PresenterContract.presenterSplash presenterSplash;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Log.d(tagLog, "onCreate");
        //
        DBHelper dbHelper = new DBHelper(this, this);
        this.presenterSplash = new SplashPresenter(this);
        //
        presenterSplash.setInstances(this, dbHelper.getWritableDatabase() );
        //
        presenterSplash.paraMainActivity();
        //
    }

    @Override
    public void message(String msg) { /**/ }

    @Override
    public Activity getActivity() { return this; }
}