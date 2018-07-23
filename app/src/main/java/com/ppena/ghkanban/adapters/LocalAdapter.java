package com.ppena.ghkanban.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ppena.ghkanban.R;
import com.ppena.ghkanban.entities.Repository;

import java.util.List;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.RepoLocalVH> {

    Context context;
    List<Repository> repos;
    LocalCallback callback;

    public LocalAdapter(Context context, List<Repository> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoLocalVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_local, parent, false);
        return new RepoLocalVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoLocalVH holder, int position) {
        Repository item  = repos.get(position);

        holder.name.setText(item.getName());
        holder.author.setText(item.getAuthor());

        holder.itemView.setOnClickListener(v -> callback.addLocalRepo(item));

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void addRepoCallback(LocalCallback callback){
        this.callback = callback;
    }

    public interface LocalCallback{
        void addLocalRepo(Repository repo);
    }

    public class RepoLocalVH extends RecyclerView.ViewHolder{

        TextView name, author;

        public RepoLocalVH(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_repo);
            author = itemView.findViewById(R.id.author_repo);
        }
    }
}
