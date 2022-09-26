package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.MainPresenter;

import org.w3c.dom.Text;

public class PerfilUserActivity extends AppCompatActivity implements MainPresenter.view  {
    private static final String tagLog = "PerfilUserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Log.d(tagLog, tagLog+"/onCreate");
        //
        TextView tvId = (TextView) findViewById(R.id.tvIdUser);
        TextView tvNome = (TextView) findViewById(R.id.tvNomeUser);
        TextView tvLogin = (TextView) findViewById(R.id.tvLoginUser);
        //
        tvLogin.setText(getIntent().getStringExtra("LOGIN"));
        //
    }//fim onCreate
    //
    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }
    //
    @Override
    public Activity getActivity() { return this; }
}//fim class