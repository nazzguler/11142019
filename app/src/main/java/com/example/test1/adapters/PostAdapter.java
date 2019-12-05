package com.example.test1.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.model.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostModel> postList;

    public PostAdapter(List<PostModel> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout postItem = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);

        PostViewHolder postViewHolder = new PostViewHolder(postItem);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setTitle(postList.get(position).title);
        holder.setBody(postList.get(position).body);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout postItem;

        public PostViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            postItem = itemView;
        }

        void setTitle(String title){
            ( (TextView) postItem.findViewById(R.id.title_tv) ).setText(title);
        }

        void setBody(String body){
            ( (TextView) postItem.findViewById(R.id.body_tv) ).setText(body);
        }
    }
}
