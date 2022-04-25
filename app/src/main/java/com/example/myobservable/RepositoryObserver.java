package com.example.myobservable;

public interface RepositoryObserver {
    void onUserDataChanged(String fullname, int age);
}
