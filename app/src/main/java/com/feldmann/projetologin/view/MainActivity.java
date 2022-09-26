package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.view.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String tagLog = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tagLog, tagLog+"/onCreate");
        //
        User.getUsers().get(0);
        this.paraTelaLogin();
    }

    public void paraTelaLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}