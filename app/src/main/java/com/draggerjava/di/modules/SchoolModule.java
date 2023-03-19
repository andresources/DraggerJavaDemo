package com.draggerjava.di.modules;

import com.draggerjava.di.modals.SchoolDetails;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolModule {
    public SchoolModule(){

    }
    @Singleton
    @Provides
    public SchoolDetails provideSchoolDetails(){
        return new SchoolDetails();
    }
}
