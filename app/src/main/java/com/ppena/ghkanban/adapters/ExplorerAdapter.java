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

/**
 * Adaptador creado para la creacion de la lista de repositores existentes en Github
 *
 * @author Pablo Andres Pena
 */

public class ExplorerAdapter extends RecyclerView.Adapter<ExplorerAdapter.RepositoryVH> {

    Context context;
    List<Repository> repos;
    RepoCallback callback;

    public ExplorerAdapter(Context context, List<Repository> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepositoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_explorer, parent, false);
        return new RepositoryVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryVH holder, int position) {
        Repository item  = repos.get(position);

        holder.name.setText(item.getName());
        holder.author.setText(item.getAuthor());

        holder.add.setOnClickListener(v -> callback.addRepo(position));

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void addRepoCallback(RepoCallback callback){
        this.callback = callback;
    }

    public interface RepoCallback{
        void addRepo(int pos);
    }

    public class RepositoryVH extends RecyclerView.ViewHolder{

        TextView name, author;
        ImageButton add;

        public RepositoryVH(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_repo);
            author = itemView.findViewById(R.id.author_repo);
            add = itemView.findViewById(R.id.btn_add);
        }
    }
}
