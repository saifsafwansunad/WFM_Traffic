package com.example.wfm_traffic.model;

public class MessagesModel {
    private int msgImage;
    private String senderName;
    private String senderCity;
    private String sendjob;
    private String sendercompany;


    public int getMsgImage() {
        return msgImage;
    }

    public void setMsgImage(int msgImage) {
        this.msgImage = msgImage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSendjob() {
        return sendjob;
    }

    public void setSendjob(String sendjob) {
        this.sendjob = sendjob;
    }

    public String getSendercompany() {
        return sendercompany;
    }

    public void setSendercompany(String sendercompany) {
        this.sendercompany = sendercompany;
    }

    public MessagesModel(int msgImage, String senderName, String senderCity, String sendjob, String sendercompany) {
        this.msgImage = msgImage;
        this.senderName = senderName;
        this.senderCity = senderCity;
        this.sendjob = sendjob;
        this.sendercompany = sendercompany;
    }


}
