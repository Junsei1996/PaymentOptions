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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentoptions.R;
import com.example.paymentoptions.adapter.PaymentOptionsAdapter;
import com.example.paymentoptions.databinding.FragmentPaymentOptionsBinding;

public class PaymentOptionsFragment extends Fragment {

    FragmentPaymentOptionsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        binding.rvPaymentOptions.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvPaymentOptions.setAdapter(new PaymentOptionsAdapter());

    }

}
