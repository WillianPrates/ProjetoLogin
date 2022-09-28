package com.feldmann.projetologin.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feldmann.projetologin.model.Todos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
//
public class TodosDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "TodosDataBase";
    //
    private static List<Todos> todos;
    private static TodosDataBase instance = null;
    //
    private TodosDataBase(Context context){
        super();
        if (todos == null){
            todos = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/todos";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this );
            queue.add(jaRequest);
        }
    }
    //
    public static List<Todos> getTodos(){ return todos; }
    //
    public static TodosDataBase getInstance(Context context){
        instance = new TodosDataBase(context);
        return instance;
    }
    //
    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }
    //
    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                todos.add( new Todos(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed")
                )/* fim new todos */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
