package com.example.book;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface retrofitInterface {

    @POST("singin")
    Call<LoginRecieve> getpo(@Body Logindetails logindetails);
}


