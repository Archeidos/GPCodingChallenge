package com.example.mbtho.geniusplazachallenge.addprofile;

import com.example.mbtho.geniusplazachallenge.base.BasePresenter;
import com.example.mbtho.geniusplazachallenge.base.BaseView;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;
import com.example.mbtho.geniusplazachallenge.profiles.ProfilesContract;

import java.util.ArrayList;

public interface AddProfileContract {

    interface View extends BaseView {

        void showProfiles();

    }

    interface Presenter extends BasePresenter {

        void destroy();

        void fetchUserProfiles();

        void submitUserProfile();


    }

    interface GetUserProfileInteractor {



    }

}
