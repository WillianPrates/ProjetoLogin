package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.MainPresenter;
import com.feldmann.projetologin.repository.UserDataBase;

public class CadastroActivity extends AppCompatActivity {
    private static final String tagLog = "CadastroActivity";
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        //
        Log.d(tagLog, tagLog+"/onCreate");
        //
        ((Button)findViewById(R.id.btEnviarCadastro)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // enviar dados pra DB
                UserDataBase.getInstance().criarUser(
                        ((EditText)findViewById(R.id.etNomeCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etLoginCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etSenhaCadastro)).getText().toString()
                );
            }
        });
    }
}