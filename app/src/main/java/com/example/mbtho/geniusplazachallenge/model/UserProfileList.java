package com.example.mbtho.geniusplazachallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserProfileList {

    @SerializedName("data")
    private ArrayList<UserProfile> userProfileList;

    public ArrayList<UserProfile> getUserProfileArrayList() {
        return userProfileList;
    }

    public void setUserProfileArrayList(ArrayList<UserProfile> userProfileArrayList) {
        this.userProfileList = userProfileArrayList;
    }


}
