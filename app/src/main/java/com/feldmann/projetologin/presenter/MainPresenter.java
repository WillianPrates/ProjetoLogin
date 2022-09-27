package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.feldmann.projetologin.view.LoginActivity;

public class MainPresenter implements PresenterContract.presenterMain{
    //
    private Intent intent;
    private PresenterContract.view view;
    public MainPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void paraTelaLogin(Button btnTelaLogin) {
        btnTelaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), LoginActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListPosts(Button btnListPost) {
        btnListPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListComments(Button ListComment) {
        ListComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListAlbuns(Button ListAlbum) {
        ListAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListPhotos(Button ListPhoto) {
        ListPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListTodos(Button ListTodo) {
        ListTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListUsers(Button ListUser) {
        ListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), .class);
                view.getActivity().startActivity(intent);
            }
        });
    }
}
