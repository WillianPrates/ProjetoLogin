package com.feldmann.projetologin.presenter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.feldmann.projetologin.repository.AlbunsDataBase;
import com.feldmann.projetologin.repository.CommentsDataBase;
import com.feldmann.projetologin.repository.PhotosDataBase;
import com.feldmann.projetologin.repository.PostsDataBase;
import com.feldmann.projetologin.repository.TodosDataBase;
import com.feldmann.projetologin.repository.UserDataBase;
import com.feldmann.projetologin.view.MainActivity;

public class SplashPresenter implements PresenterContract.presenterSplash{
    //
    private PresenterContract.view view;
    public SplashPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void paraMainActivity() {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        view.getActivity().startActivity(intent);
    }

    @Override
    public void setInstances(Context context, SQLiteDatabase sqlWrite) {
        PostsDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
        CommentsDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
        AlbunsDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
        PhotosDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
        TodosDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
        UserDataBase.getInstance(context, sqlWrite); // IMPLEMENTADO SQLITE
    }
}
