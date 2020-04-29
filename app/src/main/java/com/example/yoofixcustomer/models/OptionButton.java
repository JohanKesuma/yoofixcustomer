package com.example.yoofixcustomer.models;

import android.content.Context;
import android.view.View;

public abstract class OptionButton {
    protected String text;
    protected String id;

    public OptionButton(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void onClick(View view);
}
