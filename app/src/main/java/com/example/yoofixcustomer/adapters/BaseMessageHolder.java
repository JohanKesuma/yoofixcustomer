package com.example.yoofixcustomer.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.models.Message;

public abstract class BaseMessageHolder extends RecyclerView.ViewHolder {
    public BaseMessageHolder(@NonNull View itemView) {
        super(itemView);
    }

    abstract void bind(Message message);
}
