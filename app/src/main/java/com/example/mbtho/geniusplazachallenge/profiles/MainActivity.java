package com.example.mbtho.geniusplazachallenge.profiles;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mbtho.geniusplazachallenge.R;
import com.example.mbtho.geniusplazachallenge.adapter.UserProfileAdapter;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private MainContract.Presenter mPresenter;

    @BindView(R.id.recycler_view_profile_list)
    RecyclerView recyclerView;
    @BindView(R.id.add_user_fab)
    FloatingActionButton addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initRecyclerView();

        mPresenter = new MainPresenterImpl(this, new GetUserProfileInteractorImpl());
        mPresenter.fetchUserProfiles();
    }

    private void initRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(12);
        recyclerView.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.add_user_fab)
    @Override
    public void showNewProfile(){
        mPresenter.submitUserProfile();
    }


    @Override
    public void showProgress() {
        //show loading action
    }

    @Override
    public void hideProgress() {
        //hide loading action
    }

    @Override
    public void setDataToRecyclerView(ArrayList<UserProfile> userProfileArrayList) {
        UserProfileAdapter adapter = new UserProfileAdapter(userProfileArrayList, mPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }

    /** --- OTHER LIFE CYCLE METHODS -------------- **/

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
