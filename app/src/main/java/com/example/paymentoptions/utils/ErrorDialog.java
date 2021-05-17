package com.example.paymentoptions.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.paymentoptions.R;

public class ErrorDialog extends Dialog {

    String error = "";
    TextView tv;

    public ErrorDialog(@NonNull Context context) {
        super(context);
    }

    public ErrorDialog(@NonNull Context context, String error) {
        super(context);
        this.error = error;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_error);

        tv = (TextView) findViewById(R.id.tv_message);
        tv.setText(error);

    }
}
