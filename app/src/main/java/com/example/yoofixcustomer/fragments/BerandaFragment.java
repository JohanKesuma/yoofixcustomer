package com.example.yoofixcustomer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.CarouselItemDecorator;
import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.adapters.CarouselAdapter;
import com.example.yoofixcustomer.adapters.MessageAdapter;
import com.example.yoofixcustomer.models.Message;
import com.example.yoofixcustomer.models.OptionButton;
import com.example.yoofixcustomer.models.OptionButtonIntent;
import com.example.yoofixcustomer.models.OptionButtonMessage;
import com.example.yoofixcustomer.models.TextMessage;

import java.util.LinkedList;

public class BerandaFragment extends Fragment {
    private RecyclerView carouselRecyclerView;
    private CarouselAdapter carouselAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapater;
    private RecyclerView.LayoutManager messageLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        // Init carousel
        carouselRecyclerView = view.findViewById(R.id.carousel_recycler_view);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        carouselRecyclerView.setLayoutManager(layoutManager);

        String[] data = {"1", "2"};
        carouselAdapter = new CarouselAdapter(data, getContext());
        carouselRecyclerView.setAdapter(carouselAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                View centerView = findSnapView(layoutManager);
                if (centerView == null)
                    return RecyclerView.NO_POSITION;

                int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                if (layoutManager.canScrollVertically()) {
                    if (velocityY < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                return targetPosition;
            }
        };
        snapHelper.attachToRecyclerView(carouselRecyclerView);

        int carouselWidthPixel = (int) (this.getResources().getDisplayMetrics().widthPixels * 0.9f);
        float carouselHintPercent = 0.01f;
        carouselRecyclerView.addItemDecoration(new CarouselItemDecorator(getContext(), carouselWidthPixel, carouselHintPercent));
        //

        // Init chat
        messageRecyclerView = view.findViewById(R.id.message_recycler_view);

        messageLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messageRecyclerView.setLayoutManager(messageLayoutManager);

        OptionButton[] optionButtons = {new OptionButtonIntent("Perawatan AC", getContext()), new OptionButtonIntent("Instalasi AC", getContext()),
                new OptionButtonIntent("Jual AC", getContext()), new OptionButtonIntent("Bongkat AC", getContext())};

        LinkedList<Message> messages = new LinkedList<>();
        messages.addLast(new TextMessage(Message.MESSAGE_IN, "Hallo"));
        messages.addLast(new TextMessage(Message.MESSAGE_IN, "Dengan Yoofix disini,"));
        messages.addLast(new TextMessage(Message.MESSAGE_IN, "Jasa apa yang kamu butuhkan?"));
        messages.addLast(new OptionButtonMessage(Message.MESSAGE_IN, optionButtons));

        messageAdapater = new MessageAdapter(messages);
        messageRecyclerView.setAdapter(messageAdapater);
        //

        return view;
    }
}
