package com.example.mbtho.geniusplazachallenge.profiles;

import android.util.Log;

import com.example.mbtho.geniusplazachallenge.data.GetUserProfileService;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.model.UserProfileList;
import com.example.mbtho.geniusplazachallenge.network.RetrofitInstance;

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
    public void requestNewUserProfile(final OnFinishedListener onFinishedListener) {
        GetUserProfileService service = RetrofitInstance.getRetrofitInstance().create(GetUserProfileService.class);

        Call<UserProfile> call = service.createUserProfile(new UserProfile("10",
                "First",
                "Last",
                "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"
        ));

        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Log.d("test1","onFailure" + t.toString());
            }
        });


    }
}
