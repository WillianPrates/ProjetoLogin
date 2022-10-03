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
    @Override
    public void paraListPosts(Button btnListPost, String idUser, String nomeUser) {
        btnListPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), PostsActivity.class);
                intent.putExtra("ID_USER", idUser);
                intent.putExtra("NOME_USER", nomeUser);
                view.getActivity().startActivity(intent);
            }
        });
    }
    //
    @Override
    public void paraListAlbuns(Button btnListAlbum) {
        btnListAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), AlbumActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }
    //
    @Override
    public void paraListTodos(Button btnListTodo) {
        btnListTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), TodosActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }
}
