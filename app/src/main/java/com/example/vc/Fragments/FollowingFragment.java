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
import com.example.vc.adapters.FollowingRecyclerViewAdapter;
import com.example.vc.models.FollowingResponse;

import java.util.List;


public class FollowingFragment extends Fragment {

    private String [] data;
    private RecyclerView myRecyclerView;
    private List<FollowingResponse> listFollowing;

    View view;
    public static FollowingFragment newInstance(String[] i) {
        FollowingFragment followingFragment = new FollowingFragment();
        Bundle args = new Bundle();
        args.putStringArray("data", i);
        followingFragment.setArguments(args);
        return followingFragment;
    }

    public FollowingFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.following_fragment, container, false);


        if (getArguments() != null) {
            data  = getArguments().getStringArray("data");
        }

        myRecyclerView = (RecyclerView) view.findViewById(R.id.following_recyclerView);
        FollowingRecyclerViewAdapter followingRecyclerViewAdapter = new FollowingRecyclerViewAdapter(getContext(),listFollowing);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(followingRecyclerViewAdapter);


        return view;
    }
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        listFollowing =new ArrayList<>();
//
//    }

}
