package com.example.dependencyinjectiondaggerdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// @Module annotation is used in the class where
// it creates constructor object and provides dependencies
@Module
public class SharedPreferenceModule {
    private Context context;
    // initialising context from constructor
    public SharedPreferenceModule(Context context){
        this.context=context;
    }
    // @singleton annotation indicates only one object instance is created
    // @provide annotation indicates it provides object of module class
    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharePreferenceModule(Context context){

        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
