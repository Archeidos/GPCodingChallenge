package com.example.mbtho.geniusplazachallenge.profiles;

import android.util.Log;

import com.example.mbtho.geniusplazachallenge.model.UserProfile;

import java.util.ArrayList;

public class ProfilesPresenter implements ProfilesContract.Presenter, ProfilesContract.GetUserProfileInteractor.OnFinishedListener {

    private ProfilesContract.View mMainView;
    private ProfilesContract.GetUserProfileInteractor mInteractor;

    private ArrayList<UserProfile> userProfileArrayList;

    public ProfilesPresenter(ProfilesContract.View mainView, ProfilesContract.GetUserProfileInteractor interactor) {
        this.mMainView = mainView;
        this.mInteractor = interactor;
    }

    @Override
    public void destroy() {
        mMainView = null;
    }

    @Override
    public void fetchUserProfiles() {
        mInteractor.getUserProfileArrayList(this);
    }

    @Override
    public void submitUserProfile() {
        mInteractor.requestNewUserProfile(this);
    }

    @Override
    public void onFinished(ArrayList<UserProfile> userProfileArrayList) {
        this.userProfileArrayList = userProfileArrayList;
        if(mMainView != null){
            mMainView.setDataToRecyclerView(userProfileArrayList);
            mMainView.hideProgress();
        }
    }

    @Override
    public void onFinished(UserProfile userProfile) {
        userProfileArrayList.add(userProfile);
        if(mMainView != null){
            mMainView.setDataToRecyclerView(userProfileArrayList);
            mMainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.d("test1", "Listener onFailure called");
    }
}
