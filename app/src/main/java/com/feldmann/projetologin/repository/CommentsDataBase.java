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
import com.feldmann.projetologin.model.Comments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CommentsDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "CommentsDataBase";
    //
    private static List<Comments> comments;
    private static CommentsDataBase instance = null;
    private SQLiteDatabase sqlWrite;
    //
    private CommentsDataBase(Context context, SQLiteDatabase sqlWrite){
        super();
        this.sqlWrite = sqlWrite;
        if (comments == null){
            comments = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/comments";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
        }//fim if
    }//fim postsDB
    //
    public static List<Comments> getComments() { return comments; }
    //
    public static CommentsDataBase getInstance(Context context, SQLiteDatabase sqlWrite){
        instance = new CommentsDataBase(context, sqlWrite);
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
            try{
                ctv = new ContentValues();
                json = response.getJSONObject(i);
                //
                ctv.put("postId", json.getInt("postId") );
                ctv.put("_id", json.getInt("id") );
                ctv.put("nome", json.getString("name") );
                ctv.put("email", json.getString("email") );
                ctv.put("corpo", json.getString("body") );
                //
                sqlWrite.insert("comments", null, ctv);
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim classe