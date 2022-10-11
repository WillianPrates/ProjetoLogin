package com.feldmann.projetologin.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
    private static final String tagLog = "PostsDataBase";
    //
    private static List<Posts> posts;
    private static PostsDataBase instance = null;
    private SQLiteDatabase sqlWrite;
    //
    private PostsDataBase(Context context, SQLiteDatabase sqlWrite){
        super();
        this.sqlWrite = sqlWrite;
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
    public static PostsDataBase getInstance(Context context, SQLiteDatabase sqlWrite){
        instance = new PostsDataBase(context, sqlWrite);
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
        ContentValues ctv;
        JSONObject json;
        for (int i=0;i< response.length();i++){
            try{
                json = response.getJSONObject(i);
                posts.add( new Posts(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body")
                )/* fim new posts */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
            try{
                json = response.getJSONObject(i);
                ctv = new ContentValues();
                //
                ctv.put("userId", json.getInt("userId"));
                ctv.put("_id", json.getInt("id"));
                ctv.put("titulo", json.getString("title"));
                ctv.put("corpo", json.getString("body"));
                sqlWrite.insert("posts", null, ctv);
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim class