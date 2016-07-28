package com.example.jakub.zadanie4;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jakub on 28.07.2016.
 */
public interface AvatarApi {

    @GET("avatars/120/{name}.io.png")
    Call<ResponseBody> getAvatar(@Path("name") String name);

}
