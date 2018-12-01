package com.example.mbtho.geniusplazachallenge.main;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.mbtho.geniusplazachallenge.base.BasePresenter;
import com.example.mbtho.geniusplazachallenge.base.BaseView;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;

import java.util.ArrayList;

public interface MainContract {


    interface View extends BaseView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<UserProfile> userProfileArrayList);

        void showNewProfile();

        void onResponseFailure(Throwable t);


    }

    interface Presenter extends BasePresenter {

        void onStart();

        void onDestroy();

        void fetchUserProfiles();


    }

    interface GetUserProfileInteractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<UserProfile> userProfileArrayList);
            void onFailure(Throwable t);
        }

        void getUserProfileArrayList(OnFinishedListener onFinishedListener);

        void addUserProfile();



    }

}
