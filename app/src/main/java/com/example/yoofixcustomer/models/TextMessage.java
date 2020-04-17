package com.example.yoofixcustomer.models;

/**
 * Pesan yang hanya berisi text
 */
public class TextMessage extends Message {

    protected String text;

    public TextMessage(int messageType, String text) {
        super(messageType);
        this.text = text;
    }

    public TextMessage(int messageType) {
        super(messageType);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
