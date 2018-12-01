package com.example.mbtho.geniusplazachallenge.main;

import android.util.Log;
import android.widget.ImageView;

import com.example.mbtho.geniusplazachallenge.data.GetUserProfileService;
import com.example.mbtho.geniusplazachallenge.main.MainContract;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.model.UserProfileList;
import com.example.mbtho.geniusplazachallenge.network.RetrofitInstance;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserProfileInteractorImpl implements MainContract.GetUserProfileInteractor {

    @Override
    public void getUserProfileArrayList(final OnFinishedListener onFinishedListener) {

        GetUserProfileService service = RetrofitInstance.getRetrofitInstance().create(GetUserProfileService.class);

        Call<UserProfileList> call = service.getUserProfileData();

        call.enqueue(new Callback<UserProfileList>() {
            @Override
            public void onResponse(Call<UserProfileList> call, Response<UserProfileList> response) {
                onFinishedListener.onFinished(response.body().getUserProfileArrayList());
                Log.d("test1", response.body().getUserProfileArrayList().toString());
            }

            @Override
            public void onFailure(Call<UserProfileList> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.d("test1", "onFailure: " + t.getMessage());
            }
        });

    }

    @Override
    public void addUserProfile() {
        GetUserProfileService service = RetrofitInstance.getRetrofitInstance().create(GetUserProfileService.class);

        Call<UserProfile> call = service.createUserProfile(
                "first",
                "last",
                "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"
        );

        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                Log.d("test1","onResponse" + response.body().toString());
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Log.d("test1","onFailure" + t.toString());
            }
        });


    }
}
