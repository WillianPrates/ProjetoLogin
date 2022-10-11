package com.feldmann.projetologin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.presenter.MainPresenter;
import com.feldmann.projetologin.presenter.PresenterContract;

public class MainActivity extends AppCompatActivity implements PresenterContract.view {
    private static final String tagLog = "MainActivity";
    private PresenterContract.presenterMain presenterMain;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tagLog, tagLog+"/onCreate");
        //
        this.presenterMain = new MainPresenter(this);
        //
    }
    //
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tagLog, tagLog+"/onResume");
        presenterMain.telaLogin( (Button) findViewById(R.id.btLoginMain) );
        presenterMain.paraListPosts( (Button) findViewById(R.id.btListPostsMain) );
        presenterMain.paraListComment( (Button) findViewById(R.id.btListCommentMain) );
        presenterMain.paraListAlbuns( ((Button) findViewById(R.id.btListAlbunsMain)) );
        presenterMain.paraListPhoto( (Button) findViewById(R.id.btListPhotoMain) );
        presenterMain.paraListTodos( ((Button) findViewById(R.id.btListTodosMain)) );
        presenterMain.paraListUsers( ((Button) findViewById(R.id.btListUserMain)) );
    }
    //
    @Override
    public void message(String msg) { /**/ }

    @Override
    public Activity getActivity() { return this; }
}