package com.example.paymentoptions.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.paymentoptions.databinding.ItemPaymentOptionBinding;

public class PaymentOptionsAdapter extends RecyclerView.Adapter<PaymentOptionsAdapter.PaymentOptionsViewHolder> {

    @NonNull
    @Override
    public PaymentOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentOptionBinding b = ItemPaymentOptionBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new PaymentOptionsViewHolder(b);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionsViewHolder holder, int position) {

        holder.setData();

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class PaymentOptionsViewHolder extends RecyclerView.ViewHolder {

        ItemPaymentOptionBinding mBinding;

        PaymentOptionsViewHolder(ItemPaymentOptionBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        void setData() {

            mBinding.setImage("https://picsum.photos/id/237/200/300");
            mBinding.setTitle("Dummy");
            mBinding.setType("Dummy");

        }

    }


}
