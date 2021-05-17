package com.example.paymentoptions.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentoptions.databinding.ItemPaymentOptionBinding;
import com.example.paymentoptions.model.ApplicableItem;
import com.example.paymentoptions.model.Networks;

import java.util.ArrayList;

public class PaymentOptionsAdapter extends RecyclerView.Adapter<PaymentOptionsAdapter.PaymentOptionsViewHolder> {

    ArrayList<ApplicableItem> data = new ArrayList<>();

    @NonNull
    @Override
    public PaymentOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentOptionBinding b = ItemPaymentOptionBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PaymentOptionsViewHolder(b);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionsViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(Networks networks) {
        data.clear();
        data.addAll(networks.getApplicable());
        notifyDataSetChanged();
    }

    class PaymentOptionsViewHolder extends RecyclerView.ViewHolder {

        ItemPaymentOptionBinding mBinding;

        PaymentOptionsViewHolder(ItemPaymentOptionBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        void setData(ApplicableItem item) {

            mBinding.setItem(item);

        }

    }


}
