package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.PresenterContract;
import com.feldmann.projetologin.repository.UserDataBase;

public class MainActivity extends AppCompatActivity implements PresenterContract.view {
    private static final String tagLog = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tagLog, tagLog+"/onCreate");
        UserDataBase.getInstance(this);
        //
        this.paraTelaLogin();
    }

    public void paraTelaLogin(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    public void paraList(){
        ((Button)findViewById(R.id.btLoginMain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), .class);
                startActivity(intent);
            }
        });
    }
    //
    @Override
    public void message(String msg) {  }

    @Override
    public Activity getActivity() { return this; }
}