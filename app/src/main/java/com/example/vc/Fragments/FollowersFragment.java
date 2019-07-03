package com.example.vc.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vc.R;
import com.example.vc.adapters.FollowersRecyclerViewAdapter;
import com.example.vc.models.FollowersResponse;

import java.util.ArrayList;
import java.util.List;

public class FollowersFragment extends Fragment {

    View view;

    private String[] data;
    private RecyclerView myRecyclerView;
    private List<FollowersResponse> listFollowers;


    public static FollowersFragment newInstance(String[] i) {
        FollowersFragment followersFragment = new FollowersFragment();
        Bundle args = new Bundle();
        args.putStringArray("data", i);
        followersFragment.setArguments(args);
        return followersFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.followers_fragment, container, false);
        if (getArguments() != null) {
            data = getArguments().getStringArray("data");
        }
        myRecyclerView = (RecyclerView) view.findViewById(R.id.followers_recyclerView);
        FollowersRecyclerViewAdapter followersRecyclerViewAdapter = new FollowersRecyclerViewAdapter(getContext(),listFollowers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(followersRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFollowers =new ArrayList<>();

    }
}

