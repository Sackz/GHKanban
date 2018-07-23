package com.ppena.ghkanban.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ppena.ghkanban.R;
import com.ppena.ghkanban.adapters.IssuesAdapter;
import com.ppena.ghkanban.entities.Issue;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StateKanbanFragment extends Fragment implements IssuesAdapter.IssueCallback {

    List<Issue> list;
    RecyclerView rvIssues;
    int state;

    public StateKanbanFragment() {
    }

    public static StateKanbanFragment newInstance(ArrayList<Issue> list, Integer state) {

        Bundle args = new Bundle();
        StateKanbanFragment fragment = new StateKanbanFragment();
        args.putSerializable("issues", list);
        args.putInt("state", state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = (List<Issue>) getArguments().getSerializable("issues");
        state = getArguments().getInt("state");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.state_kanban_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvIssues = getActivity().findViewById(R.id.rvIssues);

        IssuesAdapter issuesAdapter = new IssuesAdapter(getActivity(),list);
        issuesAdapter.addIssueCallback(this::addIssue);

        rvIssues.setAdapter(issuesAdapter);


    }

    @Override
    public void addIssue(Issue repo) {

    }
}
