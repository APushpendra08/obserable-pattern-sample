package com.example.myobservable.builtInObservable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myobservable.R;

import java.util.Observable;
import java.util.Observer;

public class UserProfileActivity extends AppCompatActivity implements Observer {

    private Observable mUserDataRepositoryObservable;
    private TextView mName;
    private TextView mAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile2);

        mName = findViewById(R.id.tv_name);
        mAge = findViewById(R.id.tv_age);
        mUserDataRepositoryObservable = UserDataRepository.getInstance();
        mUserDataRepositoryObservable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof  UserDataRepository){
            UserDataRepository userDataRepository = (UserDataRepository) observable;
            mName.setText(userDataRepository.getmFullName());
            mAge.setText(userDataRepository.getmAge() + "");
        }
    }

    @Override
    protected void onDestroy() {
        mUserDataRepositoryObservable.deleteObserver(this);
        super.onDestroy();
    }
}