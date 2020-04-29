package com.example.yoofixcustomer.models;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.yoofixcustomer.activities.ChatActivity;

public class OptionButtonIntent extends OptionButton {
    public static final String OPTION_TEXT_KEY = "OPTION_TEXT";
    public static final String KEY_OPTION_ID = "option_id";

    private Context context;

    public OptionButtonIntent(String id, String text, Context context) {
        super(id, text);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(OPTION_TEXT_KEY, text);
        intent.putExtra(KEY_OPTION_ID, id);
        context.startActivity(intent);
    }
}
