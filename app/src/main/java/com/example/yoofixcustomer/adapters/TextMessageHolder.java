package com.example.yoofixcustomer.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.TextMessage;

public class TextMessageHolder extends BaseMessageHolder {
    private TextView messageTextView;

    public TextMessageHolder(@NonNull View itemView) {
        super(itemView);
        messageTextView = itemView.findViewById(R.id.message_text_view);
    }

    @Override
    void bind(Message message) {
        TextMessage textMessage = (TextMessage) message;
        messageTextView.setText(textMessage.getText());
    }
}
