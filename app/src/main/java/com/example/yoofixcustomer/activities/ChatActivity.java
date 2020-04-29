package com.example.yoofixcustomer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.adapters.MessageAdapter;
import com.example.yoofixcustomer.databases.AppExecutors;
import com.example.yoofixcustomer.databases.PerawatanDatabase;
import com.example.yoofixcustomer.entities.Keluhan;
import com.example.yoofixcustomer.entities.Perawatan;
import com.example.yoofixcustomer.models.DateMessage;
import com.example.yoofixcustomer.models.HourMessage;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.OptionButton;
import com.example.yoofixcustomer.models.OptionButtonChat;
import com.example.yoofixcustomer.models.OptionButtonIntent;
import com.example.yoofixcustomer.models.OptionButtonMessage;
import com.example.yoofixcustomer.models.TextMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity implements OptionButtonChat.OptionButtonClickListener {
    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapter;
    private RecyclerView.LayoutManager messageLayoutManager;

    private LinkedList<Message> messages;

    private PerawatanDatabase perawatanDatabase;

    private String perawatanId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String outMessageText = getIntent().getStringExtra(OptionButtonIntent.OPTION_TEXT_KEY);
        perawatanId = getIntent().getStringExtra(OptionButtonIntent.KEY_OPTION_ID);

        // Init chat
        messageRecyclerView = findViewById(R.id.message_recycler_view);

        messageLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        messageRecyclerView.setLayoutManager(messageLayoutManager);

        perawatanDatabase = PerawatanDatabase.getInstance(this);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                Perawatan perawatan = perawatanDatabase.perawatanDao().getById(perawatanId);

                messages = new LinkedList<>();
                messages.addLast(new TextMessage(Message.MESSAGE_IN, "Jasa apa yang kamu butuhkan?"));
                messages.addLast(new TextMessage(Message.MESSAGE_OUT, perawatan.getText()));
                messages.addLast(new TextMessage(Message.MESSAGE_IN, "Keluhan?"));

                updateUi();
            }
        });


    }

    private void postMessage(String message, int answerType) {
        int position = messages.size() - 1;
        messages.set(position, new TextMessage(Message.MESSAGE_OUT, message));
        messageAdapter.notifyItemChanged(position);

        if (answerType == Message.TYPE_DATE) {
            messages.addLast(new TextMessage(Message.MESSAGE_IN, "Kapan kamu membutuhkannya?"));
            messageAdapter.notifyItemInserted(messages.size());
            messages.addLast(new DateMessage(Message.MESSAGE_IN, "EEEE, dd/MM/yyyy", Locale.getDefault(), this));
            messageAdapter.notifyItemInserted(messages.size());
        } else if (answerType == Message.TYPE_HOUR) {
            messages.addLast(new TextMessage(Message.MESSAGE_IN, "Jam?"));
            messageAdapter.notifyItemInserted(messages.size());
            messages.addLast(new HourMessage(Message.MESSAGE_IN, this));
            messageAdapter.notifyItemInserted(messages.size());
        } else if (answerType == Message.TYPE_FINISH) {
            RelativeLayout bottomLayout = findViewById(R.id.bottom_layout);
            bottomLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onOptionButtonClicked(View v, String text, int answerType) {
        postMessage(text, answerType);
    }

    private void updateUi() {
        messageAdapter = new MessageAdapter(messages);
        messageRecyclerView.setAdapter(messageAdapter);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<Keluhan> keluhanList = perawatanDatabase.keluhanDao().getByPerawatanId(perawatanId);

                int size = keluhanList.size();

                OptionButton[] keluhanOptionButtons = new OptionButton[size];
                for (int i = 0; i < size; i++) {
                    Keluhan keluhan = keluhanList.get(i);
                    keluhanOptionButtons[i] = new OptionButtonChat(keluhan.getKeluhanId(), keluhan.getText(), messages, messageAdapter, Message.TYPE_DATE, ChatActivity.this);
                }
                messages.addLast(new OptionButtonMessage(Message.MESSAGE_IN, keluhanOptionButtons));
                messageAdapter.notifyItemChanged(messages.size() - 1);
            }
        });
    }

    public void onNextButtonClicked(View view) {
        Intent intent = new Intent(this, OrderMapActivity.class);
        startActivity(intent);
    }
}
