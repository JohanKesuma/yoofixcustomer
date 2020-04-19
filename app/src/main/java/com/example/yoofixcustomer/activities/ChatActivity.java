package com.example.yoofixcustomer.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.adapters.MessageAdapter;
import com.example.yoofixcustomer.models.DateMessage;
import com.example.yoofixcustomer.models.HourMessage;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.OptionButton;
import com.example.yoofixcustomer.models.OptionButtonChat;
import com.example.yoofixcustomer.models.OptionButtonIntent;
import com.example.yoofixcustomer.models.OptionButtonMessage;
import com.example.yoofixcustomer.models.TextMessage;

import java.util.LinkedList;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity implements OptionButtonChat.OptionButtonClickListener {
    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapter;
    private RecyclerView.LayoutManager messageLayoutManager;

    private LinkedList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String outMessageText = getIntent().getStringExtra(OptionButtonIntent.OPTION_TEXT_KEY);

        // Init chat
        messageRecyclerView = findViewById(R.id.message_recycler_view);

        messageLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        messageRecyclerView.setLayoutManager(messageLayoutManager);

        messages = new LinkedList<>();
        messages.addLast(new TextMessage(Message.MESSAGE_IN, "Jasa apa yang kamu butuhkan?"));
        messages.addLast(new TextMessage(Message.MESSAGE_OUT, outMessageText));
        messages.addLast(new TextMessage(Message.MESSAGE_IN, "Keluhan?"));


        messageAdapter = new MessageAdapter(messages);
        messageRecyclerView.setAdapter(messageAdapter);
        OptionButton[] keluhanOptionButtons = {new OptionButtonChat("Cuci AC", messages, messageAdapter, this), new OptionButtonChat("AC Bocor", messages, messageAdapter, this),
                new OptionButtonChat("AC Mati", messages, messageAdapter, this)};
        messages.addLast(new OptionButtonMessage(Message.MESSAGE_IN, keluhanOptionButtons));
        messageAdapter.notifyItemChanged(messages.size() - 1);
    }

    private void postMessage(String message) {
        int position = messages.size() - 1;
        messages.set(position, new TextMessage(Message.MESSAGE_OUT, message));
        messageAdapter.notifyItemChanged(position);

        if (message.equalsIgnoreCase("Cuci AC")) {
            messages.addLast(new TextMessage(Message.MESSAGE_IN, "Kapan kamu membutuhkannya?"));
            messageAdapter.notifyItemInserted(messages.size());
            messages.addLast(new DateMessage(Message.MESSAGE_IN, "EEEE, dd/MM/yyyy", Locale.getDefault(), this));
            messageAdapter.notifyItemInserted(messages.size());
        } else {
            messages.addLast(new TextMessage(Message.MESSAGE_IN, "Jam?"));
            messageAdapter.notifyItemInserted(messages.size());
            messages.addLast(new HourMessage(Message.MESSAGE_IN, this));
            messageAdapter.notifyItemInserted(messages.size());
        }
    }

    @Override
    public void onOptionButtonClicked(View v, String text) {
        postMessage(text);
    }
}
