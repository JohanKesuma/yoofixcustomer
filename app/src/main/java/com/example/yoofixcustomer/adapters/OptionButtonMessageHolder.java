package com.example.yoofixcustomer.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.OptionButtonMessage;

import java.util.LinkedList;

public class OptionButtonMessageHolder extends BaseMessageHolder {
    private RecyclerView buttonRecyclerView;

    public OptionButtonMessageHolder(@NonNull View itemView) {
        super(itemView);

        buttonRecyclerView = itemView.findViewById(R.id.button_recycler_view);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false);
        buttonRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    void bind(Message message) {
        OptionButtonMessage optionButtonMessage = (OptionButtonMessage) message;

        OptionButtonAdapter optionButtonAdapter = new OptionButtonAdapter(optionButtonMessage.getOptionButtons());
        buttonRecyclerView.setAdapter(optionButtonAdapter);
    }
}
