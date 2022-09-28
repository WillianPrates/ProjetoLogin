package com.feldmann.projetologin.repository;

import android.content.Context;
import com.feldmann.projetologin.model.Posts;
import java.util.List;

public class PostsDataBase {
    private static final String tagLog = "PostsDB";
    //
    private static List<Posts> posts;
    private static UserDataBase instance = null;
    //
    private PostsDataBase(Context context){
        super();
    }
}
