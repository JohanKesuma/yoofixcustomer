package com.example.yoofixcustomer.models;

import android.app.DatePickerDialog;

public class DateMessage extends TextMessage {

    private DatePickerDialog datePickerDialog;

    public DateMessage(int messageType, String text) {
        super(messageType, text);

    }
}
