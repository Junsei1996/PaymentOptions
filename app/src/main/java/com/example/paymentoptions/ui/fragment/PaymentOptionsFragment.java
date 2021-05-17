package com.example.paymentoptions.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.paymentoptions.R;
import com.example.paymentoptions.adapter.PaymentOptionsAdapter;
import com.example.paymentoptions.databinding.FragmentPaymentOptionsBinding;
import com.example.paymentoptions.model.PaymentOptions;
import com.example.paymentoptions.viewModel.PaymentOptionsViewModel;

public class PaymentOptionsFragment extends Fragment {

    FragmentPaymentOptionsBinding binding;
    PaymentOptionsViewModel mViewModel;
    PaymentOptionsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PaymentOptionsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_options, container, false);
        binding = (FragmentPaymentOptionsBinding) mBinding;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PaymentOptionsAdapter();

        binding.rvPaymentOptions.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvPaymentOptions.setAdapter(adapter);

        observe();
        makeNetworkCall();

    }

    private void makeNetworkCall() {
        //show loader before
        mViewModel.getPaymentData();
    }

    private void observe() {

        mViewModel.getOptions().observe(getViewLifecycleOwner(), new Observer<PaymentOptions>() {
            @Override
            public void onChanged(PaymentOptions paymentOptions) {
                //hide loader
                setDatatoAdapter(paymentOptions);
            }
        });

        mViewModel.onError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //hide loader
                showErrorDialog(s);

            }
        });

    }

    private void setDatatoAdapter(PaymentOptions paymentOptions) {

        adapter.setData(paymentOptions.getNetworks());

    }

    private void showErrorDialog(String s) {

    }

}
