package com.sparity.webchat.models;

/**
 * Created by Shankar on 9/16/2017.
 */

public class DataModel {

    private String senderId;
    //private String room;
    private String message;
    private String timestamp;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

   /* public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
