package com.example.paymentoptions.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.paymentoptions.model.PaymentOptions;
import com.example.paymentoptions.networkLayer.RetrofitApi;
import com.example.paymentoptions.networkLayer.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentOptionsViewModel extends ViewModel {

    RetrofitApi r = new RetrofitBuilder().getRetrofitService();
    MutableLiveData<PaymentOptions> options = new MutableLiveData<>();
    MutableLiveData<String> errors = new MutableLiveData<>();

    public void getPaymentData() {

        r.getPaymentOptions().enqueue(new Callback<PaymentOptions>() {
            @Override
            public void onResponse(Call<PaymentOptions> call, Response<PaymentOptions> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        options.postValue(response.body());
                    } else {
                        failure("Failed to get Data!");
                    }
                } else {
                    failure(response.message());
                }

            }

            @Override
            public void onFailure(Call<PaymentOptions> call, Throwable t) {
                failure(t.getMessage());
            }
        });

    }

    public void failure(String message) {
        errors.postValue(message);
    }

    public LiveData<String> onError() {
        return errors;
    }

    public LiveData<PaymentOptions> getOptions() {
        return options;
    }

}
