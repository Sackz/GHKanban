package com.ppena.ghkanban.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.ppena.ghkanban.R;
import com.ppena.ghkanban.adapters.ExplorerAdapter;
import com.ppena.ghkanban.adapters.LocalAdapter;
import com.ppena.ghkanban.entities.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad inicial de la aplicacion
 *
 * @author Pablo Andres Pena
 */
public class MainActivity extends AppCompatActivity implements ExplorerAdapter.RepoCallback, LocalAdapter.LocalCallback {

    TabLayout tabLayout;
    RecyclerView rvRepos;

    List<Repository> explorer,local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tabLayout = findViewById(R.id.git_tab);
         rvRepos = findViewById(R.id.rv_gits);

         explorer = new ArrayList<>();
         local = new ArrayList<>();

         for (int i = 0; i < 20; i++){
             String name = String.format("name_%d",i);
             String author = String.format("author_%d",i);
             explorer.add(new Repository(name,author));
        }
        initViews(0);

         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 initViews(tab.getPosition());
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });



    }

    public void initViews(int tabSelected){
        switch (tabSelected){
            case 0:
                ExplorerAdapter explorerAdapter = new ExplorerAdapter(this,explorer);
                explorerAdapter.addRepoCallback(this);

                rvRepos.setAdapter(explorerAdapter);
                break;
            case 1:
                LocalAdapter localAdapter = new LocalAdapter(this,local);
                localAdapter.addRepoCallback(this);

                rvRepos.setAdapter(localAdapter);
        }


    }


    @Override
    public void addRepo(int pos) {
        Repository repo = explorer.get(pos);

        local.add(repo);
        explorer.remove(pos);
    }

    @Override
    public void addLocalRepo(Repository repo) {

        Intent i = new Intent(this, KanbanActivity.class);
        i.putExtra("repo",repo);
        startActivity(i);


    }
}
