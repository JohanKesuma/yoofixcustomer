package com.example.yoofixcustomer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.DateMessage;
import com.example.yoofixcustomer.models.HourMessage;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.OptionButtonMessage;
import com.example.yoofixcustomer.models.TextMessage;

import java.util.LinkedList;

public class MessageAdapter extends RecyclerView.Adapter<BaseMessageHolder> {
    private LinkedList<Message> messages;

    public MessageAdapter(LinkedList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        Message message = messages.get(position);
        if (message instanceof TextMessage) {
            if (message.getMessageType() == Message.MESSAGE_IN) {
                viewType = R.layout.adapter_text_message_in;
            } else {
                viewType = R.layout.adapter_text_message_out;
            }
        } else if (message instanceof OptionButtonMessage) {
            viewType = R.layout.adapter_option_button_message;
        } else if (message instanceof DateMessage) {
            viewType = R.layout.adapter_date_message;
        } else if (message instanceof HourMessage) {
            viewType = R.layout.adapter_hour_message;
        }
        return viewType;
    }

    @NonNull
    @Override
    public BaseMessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType) {
            case R.layout.adapter_option_button_message:
                return new OptionButtonMessageHolder(view);
            case R.layout.adapter_date_message:
                return new DateMessageHolder(view);
            case R.layout.adapter_hour_message:
                return new HourMessageHolder(view);

            default:
                return new TextMessageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseMessageHolder holder, int position) {
        holder.bind(messages.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
