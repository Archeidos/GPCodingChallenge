package com.example.mbtho.geniusplazachallenge.data;

import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.model.UserProfileList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetUserProfileService {

    @GET("users")
    Call<UserProfileList> getUserProfileData();

    @POST("users")
    Call<UserProfile> createUserProfile(@Body UserProfile profile);


}
