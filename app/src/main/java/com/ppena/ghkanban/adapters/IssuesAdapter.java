package com.ppena.ghkanban.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ppena.ghkanban.R;
import com.ppena.ghkanban.entities.Issue;

import java.util.List;

public class IssuesAdapter extends RecyclerView.Adapter<IssuesAdapter.IssuesVH> {

    Context context;
    List<Issue> repos;
    IssueCallback callback;

    public IssuesAdapter(Context context, List<Issue> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public IssuesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_issue, parent, false);
        return new IssuesVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IssuesVH holder, int position) {
        Issue item  = repos.get(position);

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.info.setText(item.getInfo());

        holder.itemView.setOnClickListener(v -> callback.addIssue(item));

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void addIssueCallback(IssueCallback callback){
        this.callback = callback;
    }

    public interface IssueCallback{
        void addIssue(Issue repo);
    }

    public class IssuesVH extends RecyclerView.ViewHolder{

        TextView title, desc, info;

        public IssuesVH(View itemView) {
            super(itemView);


            title = itemView.findViewById(R.id.issue_title);
            desc = itemView.findViewById(R.id.issue_description);
            info = itemView.findViewById(R.id.issue_info);
        }
    }
}