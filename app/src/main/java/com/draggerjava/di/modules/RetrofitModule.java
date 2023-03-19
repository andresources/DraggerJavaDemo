package com.draggerjava.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    String mUrl;
    public RetrofitModule(String url){
        mUrl = url;
    }
    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }
    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okClient){
        return new retrofit2.Retrofit.Builder()
                .baseUrl(mUrl).client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
