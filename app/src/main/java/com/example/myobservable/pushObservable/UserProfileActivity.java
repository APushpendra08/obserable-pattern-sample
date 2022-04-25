package com.example.myobservable.pushObservable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myobservable.R;

public class UserProfileActivity extends AppCompatActivity implements RepositoryObserver {

    private Subject mUserDataRepository;
    private TextView mFullNameTextView;
    private TextView mAgeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mFullNameTextView = findViewById(R.id.tv_fullname);
        mAgeTextView = findViewById(R.id.tv_age);

        mUserDataRepository = UserDataRepository.getInstance();
        mUserDataRepository.registerObserver(this);
    }

    @Override
    public void onUserDataChanged(String fullname, int age) {
        mFullNameTextView.setText(fullname);
        mAgeTextView.setText(String.valueOf(age));
    }

    @Override
    protected void onDestroy() {
        mUserDataRepository.removeObserver(this);
        super.onDestroy();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}