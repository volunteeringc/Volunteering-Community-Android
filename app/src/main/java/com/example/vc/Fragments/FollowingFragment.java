package com.example.vc.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vc.R;



public class FollowingFragment extends Fragment {

    private String[] data;


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
            data = getArguments().getStringArray("data");
        }


        return view;
    }


}
