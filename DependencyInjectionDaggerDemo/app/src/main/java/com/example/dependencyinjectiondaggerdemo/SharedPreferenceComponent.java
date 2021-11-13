package com.example.dependencyinjectiondaggerdemo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={SharedPreferenceModule.class})
public interface SharedPreferenceComponent {
    void inject(MainActivity mainActivity);
}
