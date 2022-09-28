package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.PresenterContract;
import com.feldmann.projetologin.presenter.PerfilPresenter;
import com.feldmann.projetologin.repository.UserDataBase;

public class PerfilUserActivity extends AppCompatActivity implements PresenterContract.view  {
    private static final String tagLog = "PerfilUserActivity";
    //
    private PresenterContract.presenterPerfil presenterPerfil;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterPerfil = new PerfilPresenter(this);
        //
        presenterPerfil.mostraUser(
                getIntent().getParcelableExtra("USER_OBJECT"),
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

    public void logUsers() {
        for (int i=0;i<UserDataBase.getUsers().size();i++){
            Log.d("users",
                    "ID: "+Integer.toString(UserDataBase.getUsers().get(i).getId())+
                            " | Nome: "+UserDataBase.getUsers().get(i).getNome().toString()+
                            " | Login: "+UserDataBase.getUsers().get(i).getLogin().toString()
            );
        }
    }
}//fim class