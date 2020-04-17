package com.example.yoofixcustomer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.TextMessage;

public class MessageAdapter extends RecyclerView.Adapter<BaseMessageHolder> {
    private Message[] messages;

    public MessageAdapter(Message[] messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        Message message = messages[position];
        if (message instanceof TextMessage) {
            if (message.getMessageType() == Message.MESSAGE_IN) {
                viewType = R.layout.adapter_text_message_in;
            } else {
                viewType = R.layout.adapter_text_message_out;
            }
        }
        return viewType;
    }

    @NonNull
    @Override
    public BaseMessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType) {
            case R.layout.adapter_text_message_in:
                return new TextMessageHolder(view);
            default:
                return new TextMessageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseMessageHolder holder, int position) {
        holder.bind(messages[position]);
    }

    @Override
    public int getItemCount() {
        return messages.length;
    }
}
