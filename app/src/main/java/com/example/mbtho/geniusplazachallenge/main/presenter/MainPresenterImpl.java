package com.example.mbtho.geniusplazachallenge.main.presenter;

import android.widget.ImageView;

import com.example.mbtho.geniusplazachallenge.main.MainContract;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.Presenter, MainContract.GetUserProfileInteractor.OnFinishedListener {

    private MainContract.View mMainView;
    private MainContract.GetUserProfileInteractor mInteractor;

    public MainPresenterImpl(MainContract.View mainView, MainContract.GetUserProfileInteractor interactor) {
        this.mMainView = mainView;
        this.mInteractor = interactor;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void fetchUserProfiles() {
        mInteractor.getUserProfileArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<UserProfile> userProfileArrayList) {
        if(mMainView != null){
            mMainView.setDataToRecyclerView(userProfileArrayList);
            mMainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
