package com.example.mbtho.geniusplazachallenge.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mbtho.geniusplazachallenge.R;
import com.example.mbtho.geniusplazachallenge.adapter.UserProfileAdapter;
import com.example.mbtho.geniusplazachallenge.main.model.GetUserProfileInteractorImpl;
import com.example.mbtho.geniusplazachallenge.main.MainContract;
import com.example.mbtho.geniusplazachallenge.main.presenter.MainPresenterImpl;
import com.example.mbtho.geniusplazachallenge.model.UserProfile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private MainContract.Presenter mPresenter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

        mPresenter = new MainPresenterImpl(this, new GetUserProfileInteractorImpl());
        mPresenter.fetchUserProfiles();

    }

    private void initRecyclerView(){
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view_profile_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(12);
        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(ArrayList<UserProfile> userProfileArrayList) {
        UserProfileAdapter adapter = new UserProfileAdapter(userProfileArrayList, mPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }

    /** --- LIFE CYCLE METHODS -------------- **/

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
