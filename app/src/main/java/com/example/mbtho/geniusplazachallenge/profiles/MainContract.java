package com.example.mbtho.geniusplazachallenge.profiles;

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

        void onDestroy();

        void fetchUserProfiles();

        void submitUserProfile();


    }

    interface GetUserProfileInteractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<UserProfile> userProfileArrayList);
            void onFinished(UserProfile userProfile);
            void onFailure(Throwable t);
        }

        void getUserProfileArrayList(OnFinishedListener onFinishedListener);

        void requestNewUserProfile(OnFinishedListener onFinishedListener);

    }

}
