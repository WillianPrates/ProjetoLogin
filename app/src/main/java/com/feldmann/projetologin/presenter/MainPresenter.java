package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.feldmann.projetologin.view.AlbumActivity;
import com.feldmann.projetologin.view.CommentActivity;
import com.feldmann.projetologin.view.LoginActivity;
import com.feldmann.projetologin.view.PhotoActivity;
import com.feldmann.projetologin.view.PostsActivity;
import com.feldmann.projetologin.view.TodosActivity;
import com.feldmann.projetologin.view.UserActivity;

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
                intent = new Intent(view.getActivity(), PostsActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void paraListComments(Button btnListComment) {
        btnListComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), CommentActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }

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

    @Override
    public void paraListPhotos(Button btnListPhoto) {
        btnListPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), PhotoActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }

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

    @Override
    public void paraListUsers(Button btnListUser) {
        btnListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(view.getActivity(), UserActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }
}
