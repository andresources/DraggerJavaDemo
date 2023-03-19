package com.draggerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.draggerjava.di.component.DaggerSchoolComponent;
import com.draggerjava.modals.SchoolDetails;
import com.draggerjava.modals.StudentDetails;
import com.draggerjava.di.modules.SchoolModule;
import com.draggerjava.di.modules.SharedPrefModule;
import com.draggerjava.di.modules.StudentModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    StudentDetails stdDetails;

    @Inject
    SchoolDetails mSchoolDetails;

    @Inject
    SharedPreferences mSharedPreferences;


    TextView tvLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = findViewById(R.id.tvLog);
        DaggerSchoolComponent.builder()
                .schoolModule(new SchoolModule())
                .studentModule(new StudentModule("Hari"))
                .sharedPrefModule(new SharedPrefModule(this))
                .build()
                .inject(MainActivity.this);
        SharedPreferences.Editor e=mSharedPreferences.edit();
        e.putString("name","KSR");
        e.apply();
       if(mSchoolDetails!=null) {
           tvLog.setText(mSharedPreferences.getString("name","-"));
       }else{
           tvLog.setText("No");
       }

    }
}