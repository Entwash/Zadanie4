package com.example.jakub.zadanie4;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Jakub on 28.07.2016.
 */

public interface PersonApi {
    @GET("/")
    Observable<PersonServiceResponse> getPersonApi(@Query("results") int number);
    }
