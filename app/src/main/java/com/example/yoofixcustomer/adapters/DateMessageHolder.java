package com.example.yoofixcustomer.adapters;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.DateMessage;
import com.example.yoofixcustomer.models.Message;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateMessageHolder extends BaseMessageHolder {

    private Context context;

    private Button dateButton;
    private SimpleDateFormat simpleDateFormat;
    private DatePickerDialog datePickerDialog;

    private Calendar calendar;

    private DateMessage dateMessage;

    public DateMessageHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        calendar = Calendar.getInstance();
        dateButton = itemView.findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    @Override
    void bind(Message message) {
        dateMessage = (DateMessage) message;
        simpleDateFormat = new SimpleDateFormat(dateMessage.getFormat(), dateMessage.getLocale());
        String currentDate = simpleDateFormat.format(calendar.getTime());
        dateButton.setText(currentDate);
    }

    private void showDialog() {
        datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                dateMessage.onClick(dateButton, simpleDateFormat.format(calendar.getTime()));
//                tvDateResult.setText(simpleDateFormat.format(calendar.getTime()));
            }

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}
