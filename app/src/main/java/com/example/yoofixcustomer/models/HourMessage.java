package com.example.yoofixcustomer.models;

import android.view.View;

public class HourMessage extends Message {

    private OptionButtonChat.OptionButtonClickListener optionButtonClickListener;

    public HourMessage(int messageType, OptionButtonChat.OptionButtonClickListener optionButtonClickListener) {
        super(messageType);
        this.optionButtonClickListener = optionButtonClickListener;
    }

    public void onClick(View v, String text) {
        optionButtonClickListener.onOptionButtonClicked(v, text);
    }


}
