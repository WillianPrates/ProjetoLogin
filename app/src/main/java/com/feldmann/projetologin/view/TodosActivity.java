package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.ListsPresenter;
import com.feldmann.projetologin.presenter.PresenterContract;

public class TodosActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "TodosActivity";
    private PresenterContract.presenterLists presenterLists;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);
        //
        presenterLists.setAdapterRVTodos( ((RecyclerView) findViewById(R.id.RVTodos)) );
        //
    }
    //
    @Override
    public void message(String msg) { /**/ }
    //
    @Override
    public Activity getActivity() { return this; }
}