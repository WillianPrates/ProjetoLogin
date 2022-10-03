package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.repository.UserDataBase;
import com.feldmann.projetologin.view.AlbumActivity;
import com.feldmann.projetologin.view.PostsActivity;
import com.feldmann.projetologin.view.TodosActivity;

public class PerfilPresenter implements PresenterContract.presenterPerfil{
    private final String tagLog = this.getClass().getName();
    private Intent intent;
    //
    private PresenterContract.view view;
    public PerfilPresenter(PresenterContract.view view) { this.view = view; }
    //

    //

}
