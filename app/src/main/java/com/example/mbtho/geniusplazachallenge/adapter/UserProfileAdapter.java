package com.example.mbtho.geniusplazachallenge.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mbtho.geniusplazachallenge.R;
import com.example.mbtho.geniusplazachallenge.profiles.ProfilesContract;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ProfileViewHolder> {

    private ArrayList<UserProfile> mUserProfileList;
    private ProfilesContract.Presenter mMainPresenter;

    public UserProfileAdapter(ArrayList<UserProfile> userProfileList, ProfilesContract.Presenter mainPresenter) {
        this.mUserProfileList = userProfileList;
        this.mMainPresenter = mainPresenter;

    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(mUserProfileList.get(position).getFirstAndLastName());
        Picasso.get().load(mUserProfileList.get(position).getAvatar()).into(holder.avatar);
    }


    @Override
    public int getItemCount() {
        return mUserProfileList.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.avatar_image)
        ImageView avatar;
        @BindView(R.id.first_and_last_name)
        TextView name;

        ProfileViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }


}
