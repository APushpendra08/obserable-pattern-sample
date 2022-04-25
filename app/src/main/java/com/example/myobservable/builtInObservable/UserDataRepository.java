package com.example.myobservable.builtInObservable;

import android.os.Handler;

import java.util.Observable;

public class UserDataRepository extends Observable {
    private String mFullName;
    private int mAge;
    private static com.example.myobservable.builtInObservable.UserDataRepository INSTANCE;

    private UserDataRepository() {
        getNewDataFromRemote();
    }

    public static UserDataRepository getInstance(){
        if(INSTANCE == null)
            INSTANCE = new UserDataRepository();
        return INSTANCE;
    }


    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData("A Pushpendra", 22);
            }
        }, 5000);
    }

    private void setUserData(String a_pushpendra, int i) {
        mFullName = a_pushpendra;
        mAge = i;
        setChanged();
        notifyObservers();
    }

    public String getmFullName() {
        return mFullName;
    }

    public int getmAge() {
        return mAge;
    }
}
