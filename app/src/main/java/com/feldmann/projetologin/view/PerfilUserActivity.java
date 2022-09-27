package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.presenter.LoginPresenter;
import com.feldmann.projetologin.presenter.MainPresenter;
import com.feldmann.projetologin.presenter.PerfilPresenter;
import com.feldmann.projetologin.repository.UserDataBase;

public class PerfilUserActivity extends AppCompatActivity implements MainPresenter.view  {
    private static final String tagLog = "PerfilUserActivity";
    //
    private MainPresenter.presenterPerfil presenterPerfil;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterPerfil = new PerfilPresenter(this);
        //
        presenterPerfil.mostraUser(
                getIntent().getStringExtra("LOGIN"),
                (TextView) findViewById(R.id.tvIdUser),
                (TextView) findViewById(R.id.tvNomeUser),
                (TextView) findViewById(R.id.tvLoginUser)
        );
        //
    }//fim onCreate
    //
    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }
    //
    @Override
    public Activity getActivity() { return this; }
}//fim class