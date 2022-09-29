package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.ListsPresenter;
import com.feldmann.projetologin.presenter.PresenterContract;

public class PhotoActivity extends AppCompatActivity implements PresenterContract.view {
    private static final String tagLog = "PhotoActivity";
    private PresenterContract.presenterLists presenterLists;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);
        //
        presenterLists.setAdapterRVPosts( ((RecyclerView) findViewById(R.id.RVPhotos)) );
        //
    }

    @Override
    public void message(String msg) { /**/ }

    @Override
    public Activity getActivity() { return this; }
}