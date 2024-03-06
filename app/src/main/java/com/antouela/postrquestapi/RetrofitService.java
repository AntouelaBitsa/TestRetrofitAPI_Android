package com.antouela.postrquestapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initialize();
    }

    private void initialize() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //172.20.160.1
        //192.168.1.6
        //work ipv4 : 10.205.103.176
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
