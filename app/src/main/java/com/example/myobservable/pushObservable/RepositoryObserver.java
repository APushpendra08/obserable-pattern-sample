package com.example.myobservable.pushObservable;

public interface RepositoryObserver {
    void onUserDataChanged(String fullname, int age);
}
