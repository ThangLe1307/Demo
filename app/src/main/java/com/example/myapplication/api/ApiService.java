package com.example.myapplication.api;




import androidx.core.app.ComponentActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.myChar;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface ApiService
{



    Gson obj= new GsonBuilder().create();




    ApiService api=new Retrofit.Builder()
            .baseUrl("https://enka.network/")
            .addConverterFactory(GsonConverterFactory.create(obj))
            .build()
            .create(ApiService.class);

    @GET
    Call <myChar> infor(@Url String uurl);
}
