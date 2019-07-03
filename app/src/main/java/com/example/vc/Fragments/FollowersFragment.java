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
import android.widget.Toast;

import com.example.vc.API.RetrofitClient;
import com.example.vc.Constants.Constnts;
import com.example.vc.R;
import com.example.vc.adapters.FollowersRecyclerViewAdaoter;
import com.example.vc.models.FollowersResponse;
import com.example.vc.models.User;
import com.example.vc.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        FollowersRecyclerViewAdaoter followersRecyclerViewAdaoter = new FollowersRecyclerViewAdaoter(getContext(),listFollowers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(followersRecyclerViewAdaoter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFollowers =new ArrayList<>();

    }
}
//    private void Followers() {
//        User user = SharedPrefManager.getInstance(getActivity()).getUser();
//        String id = user.getId();
//        String token = user.getToken();
//
//
//        Call<FollowersResponse> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .followers(id, Constnts.getInstance().auth.concat(token));
//        call.enqueue(new Callback<FollowersResponse>() {
//            @Override
//            public void onResponse(Call<FollowersResponse> call, Response<FollowersResponse> response) {
//
//                if (response.isSuccessful()) {
//                } else {
//                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FollowersResponse> call, Throwable t) {
//
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }



