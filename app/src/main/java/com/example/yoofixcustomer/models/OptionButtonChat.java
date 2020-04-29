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
    private int answerType;

    public OptionButtonChat(String id, String text, LinkedList<Message> messages, RecyclerView.Adapter adapter) {
        super(id, text);
        this.messages = messages;
        this.messageAdapter = adapter;
    }

    public OptionButtonChat(String id, String text, LinkedList<Message> messages, RecyclerView.Adapter adapter, int answerType, OptionButtonClickListener optionButtonClickListener) {
        super(id, text);
        this.answerType = answerType;
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
            optionButtonClickListener.onOptionButtonClicked(view, text, answerType);
        }
    }

    public void setOptionButtonClickListener(OptionButtonClickListener optionButtonClickListener) {
        this.optionButtonClickListener = optionButtonClickListener;
    }

    public interface OptionButtonClickListener {
        public void onOptionButtonClicked(View v, String text, int answerType);
    }
}
