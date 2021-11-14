package com.example.retrofitdemo;

import javax.inject.Singleton;

import dagger.Component;


// @Component annotation tells Dagger what Modules to include when building the graph
@Singleton
@Component(modules = {ApiModule.class,AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
