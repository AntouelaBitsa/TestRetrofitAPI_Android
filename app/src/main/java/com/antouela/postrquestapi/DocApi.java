package com.antouela.postrquestapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DocApi {

    @POST("/postDoc")
    Call<Doctor> postDoc(@Body Doctor doctor);

    @GET("/getDoc/{id}")
    Call<Doctor> getDoc(@Path("id") Integer id);
}
