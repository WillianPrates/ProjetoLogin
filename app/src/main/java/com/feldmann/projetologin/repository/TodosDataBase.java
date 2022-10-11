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
    private SQLiteDatabase sqlWrite;
    //
    private TodosDataBase(Context context, SQLiteDatabase sqlWrite){
        super();
        this.sqlWrite = sqlWrite;
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
    public static TodosDataBase getInstance(Context context, SQLiteDatabase sqlWrite){
        instance = new TodosDataBase(context, sqlWrite);
        return instance;
    }
    //
    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }
    //
    @Override
    public void onResponse(JSONArray response) {
        ContentValues ctv;
        JSONObject json;
        for (int i=0;i< response.length();i++){
            try{
                json = response.getJSONObject(i);
                todos.add( new Todos(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed")
                )/* fim new todos */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
            try{
                ctv = new ContentValues();
                json = response.getJSONObject(i);
                //
                ctv.put("userId", json.getInt("userId") );
                ctv.put("_id", json.getInt("id") );
                ctv.put("titulo", json.getString("title") );
                ctv.put("completed", String.valueOf( json.getBoolean("completed") ) );
                sqlWrite.insert("tarefas", null, ctv);
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim classe
