package com.example.vc.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vc.API.RetrofitClient;
import com.example.vc.Constants.Constnts;
import com.example.vc.R;
import com.example.vc.adapters.ProfileViewPagerAdapter;
import com.example.vc.models.FollowingResponse;
import com.example.vc.models.ProfileResponse;
import com.example.vc.models.User;
import com.example.vc.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

    private void followingrequst() {

        User user = SharedPrefManager.getInstance(getActivity()).getUser();
        String id = user.getId();
        String token = user.getToken();

        Call<FollowingResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .following(id,Constnts.getInstance().auth.concat(token));
        call.enqueue(new Callback<FollowingResponse>() {
            @Override
            public void onResponse(Call<FollowingResponse> call, Response<FollowingResponse> response) {
                if (response.isSuccessful()) {
                } else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FollowingResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}
