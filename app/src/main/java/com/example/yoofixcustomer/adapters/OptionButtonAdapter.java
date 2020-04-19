package com.example.yoofixcustomer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.models.OptionButton;

public class OptionButtonAdapter extends RecyclerView.Adapter<OptionButtonAdapter.OptionButtonHolder> {
    private OptionButton[] optionButtons;

    public OptionButtonAdapter(OptionButton[] optionButtons) {
        this.optionButtons = optionButtons;
    }

    @NonNull
    @Override
    public OptionButtonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_option_button_list, parent, false);

        return new OptionButtonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionButtonHolder holder, final int position) {
        holder.optionButton.setText(optionButtons[position].getText());
        holder.optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtons[position].onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return optionButtons.length;
    }

    public class OptionButtonHolder extends RecyclerView.ViewHolder {
        private Button optionButton;

        public OptionButtonHolder(@NonNull View itemView) {
            super(itemView);
            optionButton = itemView.findViewById(R.id.option_button);
        }

    }
}
