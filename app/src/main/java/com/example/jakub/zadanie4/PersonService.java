package com.example.jakub.zadanie4;

import android.widget.Toast;

import retrofit2.*;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Jakub on 28.07.2016.
 */
public class PersonService {

    private static volatile PersonService mPersonService;
    private final PersonApi mPersonApi;
    public static final String BASE_URL = "http://api.randomuser.me/";

    private PersonService() {
        mPersonApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PersonApi.class);

    }

    public static PersonService getInstance() {
        if(mPersonService == null) {
            synchronized (PersonService.class) {
                if(mPersonService == null) {
                    mPersonService = new PersonService();
                }
            }
        }
        return mPersonService;
    }

    public Observable<PersonServiceResponse> getResults(final int number) {
        return mPersonApi.getPersonApi(number);
    }

}
