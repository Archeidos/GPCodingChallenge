package com.example.mbtho.geniusplazachallenge.addprofile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.mbtho.geniusplazachallenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProfileActivity extends AppCompatActivity implements AddProfileContract.View {

    private String firstName;
    private String lastName;

    @BindView(R.id.first_name_editText)
    EditText firstNameEditText;
    @BindView(R.id.last_name_editText)
    EditText lastNameEditText;
    @BindView(R.id.add_button)
    Button addButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addprofile_act);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.add_button)
    public void addClicked(){
        firstName = firstNameEditText.getText().toString();
        lastName = lastNameEditText.getText().toString();
    }

    @Override
    public void showProfiles() {

    }


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
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
