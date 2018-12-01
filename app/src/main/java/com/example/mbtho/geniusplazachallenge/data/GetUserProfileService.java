package com.example.mbtho.geniusplazachallenge.data;

import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.model.UserProfileList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetUserProfileService {

    @GET("users")
    Call<UserProfileList> getUserProfileData();

    @POST("users")
    Call<UserProfile> createUserProfile(
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("avatar") String avatarURL
    );


}
