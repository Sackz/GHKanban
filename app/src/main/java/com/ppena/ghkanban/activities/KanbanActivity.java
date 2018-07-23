
package com.ppena.ghkanban.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ppena.ghkanban.R;
import com.ppena.ghkanban.entities.Issue;
import com.ppena.ghkanban.fragments.StateKanbanFragment;

import java.util.ArrayList;

public class KanbanActivity extends AppCompatActivity {

    ArrayList<Issue> backlog,next,doing,done;
    ViewPager pager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban);


        tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager_kanban);

        backlog = new ArrayList<>();
        next = new ArrayList<>();
        doing = new ArrayList<>();
        done = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            String title = String.format("title_%d",i);
            String desc = String.format("desc_%d",i);
            String info = String.format("info_%d",i);
            backlog.add(new Issue(title,desc,info));
            next.add(new Issue(title,desc,info));
            doing.add(new Issue(title,desc,info));
            done.add(new Issue(title,desc,info));
        }

        pager.setAdapter(new KanbanPagerAdapter(getSupportFragmentManager()));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public class KanbanPagerAdapter extends FragmentPagerAdapter {

        public KanbanPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return StateKanbanFragment.newInstance(backlog, position);
                case 1:
                    return StateKanbanFragment.newInstance(next, position);
                case 2:
                    return StateKanbanFragment.newInstance(doing, position);
                default:
                    return StateKanbanFragment.newInstance(done, position);
            }
        }
    }




    }

