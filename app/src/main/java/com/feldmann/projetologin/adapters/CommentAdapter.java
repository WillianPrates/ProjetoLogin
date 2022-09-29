package com.feldmann.projetologin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.Comments;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private List<Comments> dadosComments;
    //
    public CommentAdapter(List<Comments> dadosComments) { this.dadosComments = dadosComments; }
    //
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comments_list, parent, false);
        return new CommentViewHolder(layoutViewHolder);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comments objComment = dadosComments.get(position);
        ((TextView)((CommentViewHolder) holder).view.findViewById(R.id.tvPostID)).setText("Post ID: "+Integer.toString(objComment.getPostID()));
        ((TextView)((CommentViewHolder) holder).view.findViewById(R.id.tvCommentID)).setText("Comment ID: "+Integer.toString(objComment.getId()));
        ((TextView)((CommentViewHolder) holder).view.findViewById(R.id.tvCommentName)).setText("Nome: "+objComment.getName());
        ((TextView)((CommentViewHolder) holder).view.findViewById(R.id.tvCommentEmail)).setText("Email: "+objComment.getEmail());
        ((TextView)((CommentViewHolder) holder).view.findViewById(R.id.tvCommentBody)).setText(" "+objComment.getBody());
    }
    //
    @Override
    public int getItemCount() { return dadosComments.size(); }
    //
}
class CommentViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public CommentViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}
