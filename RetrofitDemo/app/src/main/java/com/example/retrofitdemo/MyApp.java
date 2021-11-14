package com.example.retrofitdemo;

import android.app.Application;

//Mention the application name in the manifest file
public class MyApp extends Application {

    private  AppComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://reqres.in/api/users?page=2"))
                .build();
    }

    public AppComponent getApiComponent() {
        return apiComponent;
    }
}
