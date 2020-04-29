package com.example.yoofixcustomer.models;

/**
 * BaseClass untuk Message
 */
public class Message {
    public static final int TYPE_FINISH = 0;
    public static final int TYPE_OPTION = 1;
    public static final int TYPE_DATE = 2;
    public static final int TYPE_HOUR = 3;


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
