package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.presenter.MainPresenter;
import com.feldmann.projetologin.repository.UserDataBase;

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
        String sLogin = getIntent().getStringExtra("LOGIN");
        UserDataBase db = UserDataBase.getInstance();
        User user = db.getUserByLogin(sLogin);
        //
        String id = user.getId()
        tvId.setText(user.getId());
        tvNome.setText(user.getNome());
        tvLogin.setText(user.getLogin());
        //
    }//fim onCreate
    //
    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }
    //
    @Override
    public Activity getActivity() { return this; }
}//fim class