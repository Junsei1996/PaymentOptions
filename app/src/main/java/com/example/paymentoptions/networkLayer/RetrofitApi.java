package com.example.paymentoptions.networkLayer;

import com.example.paymentoptions.model.PaymentOptions;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("/optile/checkout-android/develop/shared-test/lists/listresult.json")
    Call<PaymentOptions> getPaymentOptions();

}
