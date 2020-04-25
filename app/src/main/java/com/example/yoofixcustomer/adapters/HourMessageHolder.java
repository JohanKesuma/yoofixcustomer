package com.example.yoofixcustomer.adapters;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.HourMessage;
import com.example.yoofixcustomer.models.Message;

import java.util.Calendar;

public class HourMessageHolder extends BaseMessageHolder {
    private TimePickerDialog timePickerDialog;
    private Button hourButton;
    private Calendar calendar;
    private Context context;

    private HourMessage hourMessage;

    public HourMessageHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        hourButton = itemView.findViewById(R.id.hour_button);
        hourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        calendar = Calendar.getInstance();

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        hourButton.setText(hour + ":" + minute);


    }

    @Override
    void bind(Message message) {
        hourMessage = (HourMessage) message;

    }

    private void showTimePicker() {
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hourMessage.onClick(hourButton, hourOfDay + ":" + minute);
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }
}
