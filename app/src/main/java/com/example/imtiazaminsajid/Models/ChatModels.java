package com.example.imtiazaminsajid.Models;

/**
 * Created by Imtiaz Amin Sajid on 3/14/2018.
 */

public class ChatModels {
    public String message;
    boolean isSend;

    public ChatModels(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public ChatModels() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
