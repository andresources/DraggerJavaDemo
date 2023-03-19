package com.draggerjava.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.draggerjava.R;
import com.draggerjava.di.component.DaggerSchoolComponent;
import com.draggerjava.di.modules.RetrofitModule;
import com.draggerjava.di.modules.SchoolModule;
import com.draggerjava.di.modules.SharedPrefModule;
import com.draggerjava.di.modules.StudentModule;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitActivity extends AppCompatActivity {
    @Inject
    Retrofit mRetrofit;
    String BASE_URL = "https://jsonplaceholder.typicode.com";
    TextView tvLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        tvLog = findViewById(R.id.tvLog);

        DaggerSchoolComponent.builder()
                .schoolModule(new SchoolModule())
                .studentModule(new StudentModule("Hari"))
                .sharedPrefModule(new SharedPrefModule(this))
                .retrofitModule(new RetrofitModule(BASE_URL)).build().inject(RetrofitActivity.this);
        GetDataService service = mRetrofit.create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
               int size = response.body().size();
                tvLog.setText(size+"");

            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {

            }
        });
    }

}