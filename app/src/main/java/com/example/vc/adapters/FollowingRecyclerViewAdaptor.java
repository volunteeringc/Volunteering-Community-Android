package com.example.vc.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vc.R;
import com.example.vc.models.FollowingResponse;

import java.util.List;

public class FollowingRecyclerViewAdaptor extends RecyclerView.Adapter<FollowingRecyclerViewAdaptor.MyViewHolder> {


    Context mContext;
    List<FollowingResponse> mData;

    public FollowingRecyclerViewAdaptor(Context mContext, List<FollowingResponse> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public FollowingRecyclerViewAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_following, viewGroup, false);

        FollowingRecyclerViewAdaptor.MyViewHolder vHolder = new FollowingRecyclerViewAdaptor.MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingRecyclerViewAdaptor.MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText(mData.get(i).getFollowing().length);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.Name_followers);
            img = (ImageView) itemView.findViewById(R.id.img_followers);
        }


    }
}