package com.feldmann.projetologin.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feldmann.projetologin.model.Posts;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PostsDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "PostsDB";
    //
    private static List<Posts> posts;
    private static PostsDataBase instance = null;
    //
    private PostsDataBase(Context context){
        super();
        if (posts == null){
            posts = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/posts";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
            //
        }//fim if
    }//fim postsDB
    //
    public static List<Posts> getPosts() { return posts; }
    //
    public static PostsDataBase getInstance(Context context){
        instance = new PostsDataBase(context);
        return instance;
    }
    //
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(tagLog, tagLog+"/"+error.getMessage());
    }
    //
    @Override
    public void onResponse(JSONArray response) {
        response.length();
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                posts.add( new Posts(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body")
                )/* fim new posts */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim class
