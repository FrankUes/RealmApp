package com.example.frank.realmapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Frank on 28/07/2017.
 */

public class BaseAplication extends Application {
    public static BaseAplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        instance = this;


    }

    public static BaseAplication getInstance(){
        return instance;
    }

}
