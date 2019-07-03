package com.example.vc.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vc.R;


public class FollowersFragment extends Fragment {

    View view;

    private String[] data;


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
        return view;
    }


}

