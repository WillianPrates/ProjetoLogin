package com.feldmann.projetologin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.Posts;
import com.feldmann.projetologin.model.Todos;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private List<Todos> dadosTodo;
    //
    public TodoAdapter(List<Todos> dadosTodo) { this.dadosTodo = dadosTodo; }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todo_list, null, false);
        return new TodoViewHolder(layoutViewHolder);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //
        Todos objTodo = dadosTodo.get(position);
        ((TextView)((TodoViewHolder) holder).view.findViewById(R.id.tvIdUserTodo)).setText("User: "+Integer.toString(objTodo.getUserID()));
        ((TextView)((TodoViewHolder) holder).view.findViewById(R.id.tvIdTodo)).setText("ID: "+Integer.toString(objTodo.getId()));
        ((TextView)((TodoViewHolder) holder).view.findViewById(R.id.tvTitleTodo)).setText("Titulo: "+objTodo.getTitle());
        if (objTodo.isCompleted()){
            ((TextView)((TodoViewHolder) holder).view.findViewById(R.id.tvCompleteTodo)).setText("Status: "+"OK");
        }else{
            ((TextView)((TodoViewHolder) holder).view.findViewById(R.id.tvCompleteTodo)).setText("Status: "+"X");
        }
    }
    //
    @Override
    public int getItemCount() { return dadosTodo.size(); }
    //
}
class TodoViewHolder extends RecyclerView.ViewHolder {
    public View view;
    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
