package com.example.myobservable.pushObservable;

import android.os.Handler;

import java.util.ArrayList;

public class UserDataRepository implements Subject {
    private String mFullName;
    private int mAge;
    private static UserDataRepository INSTANCE = null;

    private ArrayList<RepositoryObserver> mObservers;

    private UserDataRepository() {
        this.mObservers = new ArrayList<RepositoryObserver>();
        getNewDataFromRemote();
    }

    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData("Chike Mgbemena", 101);
            }
        }, 10000);
    }

    public static UserDataRepository getInstance(){
        if(INSTANCE == null)
            INSTANCE = new UserDataRepository();
        return INSTANCE;
    }

    private void setUserData(String chike_mgbemena, int i) {
        mFullName = chike_mgbemena;
        mAge = i;
        notifyObservers();
    }

    @Override
    public void registerObserver(RepositoryObserver repositoryObserver) {
        if(!mObservers.contains(repositoryObserver))
            mObservers.add(repositoryObserver);
    }

    @Override
    public void removeObserver(RepositoryObserver repositoryObserver) {
        if(mObservers.contains(repositoryObserver))
            mObservers.remove(repositoryObserver);
    }

    @Override
    public void notifyObservers() {
        for (RepositoryObserver repositoryObserver : mObservers)
            repositoryObserver.onUserDataChanged(mFullName, mAge);
    }
}
