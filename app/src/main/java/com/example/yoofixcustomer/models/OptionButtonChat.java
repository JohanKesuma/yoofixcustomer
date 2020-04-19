package com.example.yoofixcustomer.models;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class OptionButtonChat extends OptionButton {

    /**
     * Referensi ke messages
     * digunakan untuk update message ketika tombol dipencet
     */
    private LinkedList<Message> messages;

    /**
     * Referensi ke objek messageAdapater untuk push message
     */
    private RecyclerView.Adapter messageAdapter;

    private OptionButtonClickListener optionButtonClickListener;

    public OptionButtonChat(String text, LinkedList<Message> messages, RecyclerView.Adapter adapter) {
        super(text);
        this.messages = messages;
        this.messageAdapter = adapter;
    }

    public OptionButtonChat(String text, LinkedList<Message> messages, RecyclerView.Adapter adapter, OptionButtonClickListener optionButtonClickListener) {
        super(text);
        this.messages = messages;
        this.messageAdapter = adapter;
        this.optionButtonClickListener = optionButtonClickListener;
    }

    @Override
    public void onClick(View view) {
//        int position = messages.size() - 1;
//        messages.set(position, new TextMessage(Message.MESSAGE_OUT, text));
//        messageAdapter.notifyItemChanged(position);
        if (optionButtonClickListener != null) {
            optionButtonClickListener.onOptionButtonClicked(view, text);
        }
    }

    public void setOptionButtonClickListener(OptionButtonClickListener optionButtonClickListener) {
        this.optionButtonClickListener = optionButtonClickListener;
    }

    public interface OptionButtonClickListener {
        public void onOptionButtonClicked(View v, String text);
    }
}
