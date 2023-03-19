package com.draggerjava.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {
    Context cnt;
    public SharedPrefModule(Context cnt){
        this.cnt = cnt;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return cnt;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context cnt){
     return PreferenceManager.getDefaultSharedPreferences(cnt);
    }

}
