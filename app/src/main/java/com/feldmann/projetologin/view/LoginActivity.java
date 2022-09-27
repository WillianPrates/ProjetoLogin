package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.presenter.LoginPresenter;
import com.feldmann.projetologin.presenter.MainPresenter;

public class LoginActivity extends AppCompatActivity implements MainPresenter.view {
    private static final String tagLog = "LoginActivity";
    private MainPresenter.presenterLogin presenterLogin;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(tagLog, tagLog+"/onCreate");
        //
        this.presenterLogin = new LoginPresenter(this);
        //
        ((Button)findViewById(R.id.btEntrar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tagLog, "/onClick botao entrar");
                presenterLogin.verificaUsuario(
                        ((EditText)findViewById(R.id.etLoginLogin)).getText().toString(),
                        ((EditText)findViewById(R.id.etSenhaLogin)).getText().toString()
                );
            }
        });
    }//fim onCreate

    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Activity getActivity() {
        return this;
    }
}//fim class