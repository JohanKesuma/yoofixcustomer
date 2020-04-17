package com.example.yoofixcustomer.models;

/**
 * BaseClass untuk Message
 */
public class Message {

    /**
     * Tipe pesan yang diterima oleh user saat ini
     */
    public static final int MESSAGE_IN = 1;

    /**
     * Tipe pesan yang dikirim oleh user saat ini
     */
    public static final int MESSAGE_OUT = 0;

    private int messageType;

    public Message(int messageType) {
        this.messageType = messageType;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
