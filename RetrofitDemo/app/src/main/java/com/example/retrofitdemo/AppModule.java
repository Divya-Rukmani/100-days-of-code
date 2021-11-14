package com.example.retrofitdemo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//Modules are a way of telling Dagger how to provide dependencies from the dependency graph.
//@Module to signal to Dagger to search within the available methods for possible instance providers.
@Module
public class AppModule {

    private Application application;

    AppModule(Application application){

       this.application=application;
    }


    //@Provides tell Dagger to create instances of the type that this function returns
    //Singleton annotation signals to the Dagger compiler that the instance should be created only once in the application.
    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }
}
