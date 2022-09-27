package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.presenter.CadastroPresenter;
import com.feldmann.projetologin.presenter.LoginPresenter;
import com.feldmann.projetologin.presenter.MainPresenter;
import com.feldmann.projetologin.repository.UserDataBase;

public class CadastroActivity extends AppCompatActivity implements MainPresenter.view{
    private static final String tagLog = "CadastroActivity";
    private MainPresenter.presenterCadastro presenterCadastro;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        //
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterCadastro = new CadastroPresenter(this);
        //
        ((Button)findViewById(R.id.btEnviarCadastro)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // enviar dados pra DB
                presenterCadastro.criarUsuario(
                        ((EditText)findViewById(R.id.etNomeCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etLoginCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etSenhaCadastro)).getText().toString()
                );
            }
        });
    }

    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Activity getActivity() { return this; }
}