package com.example.yoofixcustomer.models;

/**
 * Pesan yang berisi pilihan
 */
public class OptionButtonMessage extends Message {
    private OptionButton[] optionButtons;

    public OptionButtonMessage(int messageType) {
        super(messageType);
    }

    public OptionButtonMessage(int messageType, OptionButton[] options) {
        super(messageType);
        this.optionButtons = options;
    }

    public OptionButton[] getOptionButtons() {
        return optionButtons;
    }

    public void setOptionButtons(OptionButton[] optionButtons) {
        this.optionButtons = optionButtons;
    }
}
