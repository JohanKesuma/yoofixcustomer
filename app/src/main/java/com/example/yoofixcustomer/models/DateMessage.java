package com.example.yoofixcustomer.models;

import android.view.View;

import java.util.Locale;

public class DateMessage extends Message {

    private String format;
    private Locale locale;
    private OptionButtonChat.OptionButtonClickListener optionButtonClickListener;

    public DateMessage(int messageType, String format, Locale locale, OptionButtonChat.OptionButtonClickListener optionButtonClickListener) {
        super(messageType);
        this.format = format;
        this.locale = locale;
        this.optionButtonClickListener = optionButtonClickListener;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void onClick(View v, String text) {
        optionButtonClickListener.onOptionButtonClicked(v, text);
    }
}
