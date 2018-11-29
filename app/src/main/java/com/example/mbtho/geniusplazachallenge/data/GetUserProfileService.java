package com.example.mbtho.geniusplazachallenge.data;

import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.model.UserProfileList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetUserProfileService {

    @GET("c8r5u")
    Call<UserProfileList> getUserProfileData();

    @POST("users")
    Call<UserProfile> createUserProfile();


}
