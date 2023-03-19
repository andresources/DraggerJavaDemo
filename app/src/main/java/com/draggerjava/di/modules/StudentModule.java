package com.draggerjava.di.modules;

import com.draggerjava.modals.StudentDetails;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentModule {
    private String mStudentName;
    public StudentModule(String studentName){
        mStudentName = studentName;
    }

    @Singleton
    @Provides
    public StudentDetails provideStudentDetails(){
        return new StudentDetails(mStudentName);
    }
}
