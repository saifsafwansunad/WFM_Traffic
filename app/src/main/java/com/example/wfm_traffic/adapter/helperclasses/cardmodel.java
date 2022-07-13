package com.example.wfm_traffic.adapter.helperclasses;

import android.graphics.drawable.GradientDrawable;

public class cardmodel {

    int image;
    String title;
    String cardValue;

    public cardmodel(int image, String title, String cardValue) {
        this.image = image;
        this.title = title;
        this.cardValue = cardValue;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }


}
