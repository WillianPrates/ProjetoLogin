package com.feldmann.projetologin.presenter;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feldmann.projetologin.adapters.AlbumAdapter;
import com.feldmann.projetologin.adapters.CommentAdapter;
import com.feldmann.projetologin.adapters.PostAdapter;
import com.feldmann.projetologin.adapters.TodoAdapter;
import com.feldmann.projetologin.adapters.UserAdapter;
import com.feldmann.projetologin.repository.AlbunsDataBase;
import com.feldmann.projetologin.repository.CommentsDataBase;
import com.feldmann.projetologin.repository.PostsDataBase;
import com.feldmann.projetologin.repository.TodosDataBase;
import com.feldmann.projetologin.repository.UserDataBase;

import org.w3c.dom.Comment;

public class ListsPresenter implements PresenterContract.presenterLists{
    private static final String tagLog = "ListsPresenter";
    //
    private PresenterContract.view view;
    public ListsPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void setAdapterRVPosts(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVPosts");
        PostAdapter adapterPost = new PostAdapter(PostsDataBase.getPosts());
        rv.setAdapter(adapterPost);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }
    //
    @Override
    public void setAdapterRVComments(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVComments");
        CommentAdapter adapterComment = new CommentAdapter(CommentsDataBase.getComments());
        rv.setAdapter(adapterComment);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }
    //
    @Override
    public void setAdapterRVAlbuns(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVAlbuns");
        AlbumAdapter adapterAlbum = new AlbumAdapter(AlbunsDataBase.getAlbuns());
        rv.setAdapter(adapterAlbum);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }
    //
    @Override
    public void setAdapterRVPhotos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVPhotos");
    }
    //
    @Override
    public void setAdapterRVTodos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVTodos");
        TodoAdapter adapterTodo = new TodoAdapter(TodosDataBase.getTodos());
        rv.setAdapter(adapterTodo);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );

    }
    //
    @Override
    public void setAdapterRVUsers(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVUsers");
        UserAdapter adapterUser = new UserAdapter(UserDataBase.getUsers());
        rv.setAdapter(adapterUser);
        rv.setLayoutManager(new LinearLayoutManager(view.getActivity()));
    }
    //
}//fim class
