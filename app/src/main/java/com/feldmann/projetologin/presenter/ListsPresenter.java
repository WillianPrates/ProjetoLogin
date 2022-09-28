package com.feldmann.projetologin.presenter;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feldmann.projetologin.adapters.UserAdapter;
import com.feldmann.projetologin.repository.UserDataBase;

public class ListsPresenter implements PresenterContract.presenterLists{
    private static final String tagLog = "ListsPresenter";
    //
    private PresenterContract.view view;
    public ListsPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void setAdapterRVUsers(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVUsers");
        UserAdapter adapter = new UserAdapter(UserDataBase.getUsers());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(view.getActivity()));
    }
}
