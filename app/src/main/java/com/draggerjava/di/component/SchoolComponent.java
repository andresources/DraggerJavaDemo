package com.draggerjava.di.component;

import com.draggerjava.MainActivity;
import com.draggerjava.di.modules.RetrofitModule;
import com.draggerjava.di.modules.SchoolModule;
import com.draggerjava.di.modules.SharedPrefModule;
import com.draggerjava.di.modules.StudentModule;
import com.draggerjava.retrofit.RetrofitActivity;

import javax.inject.Singleton;
import dagger.Component;
@Singleton
@Component(modules = {StudentModule.class, SchoolModule.class, SharedPrefModule.class, RetrofitModule.class})
public interface SchoolComponent {
    void inject(MainActivity mainActivity);
    void inject(RetrofitActivity ac);
}
