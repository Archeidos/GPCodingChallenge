package com.example.mbtho.geniusplazachallenge.main.model;

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

}
