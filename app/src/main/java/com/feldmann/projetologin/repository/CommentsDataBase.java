package com.feldmann.projetologin.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feldmann.projetologin.model.Comments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CommentsDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "CommentsDB";
    //
    private static List<Comments> comments;
    private static CommentsDataBase instance = null;
    //
    private CommentsDataBase(Context context){
        super();
        if (comments == null){
            comments = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/comments";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
            //
        }//fim if
    }//fim postsDB
    //
    public static List<Comments> getComments() { return comments; }
    //
    public static CommentsDataBase getInstance(Context context){
        instance = new CommentsDataBase(context);
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
                comments.add( new Comments(
                        json.getInt("postId"),
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("email"),
                        json.getString("body")
                )/* fim new posts */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim class
