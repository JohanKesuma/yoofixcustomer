package com.example.yoofixcustomer.models;

import android.widget.Button;

/**
 * Pesan yang berisi pilihan
 */
public class OptionButtonMessage extends Message {
    private Button[] optionButtons;

    public OptionButtonMessage(int messageType, Button[] optionButtons) {
        super(messageType);
        this.optionButtons = optionButtons;
    }

    public OptionButtonMessage(int messageType) {
        super(messageType);
    }

    public Button[] getOptionButtons() {
        return optionButtons;
    }

    public void setOptionButtons(Button[] optionButtons) {
        this.optionButtons = optionButtons;
    }
}
