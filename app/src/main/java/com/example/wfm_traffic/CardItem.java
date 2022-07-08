package com.example.wfm_traffic;

public class CardItem {

    private int mTitleResource;
    private int mTextResource;

    public int getmTitleResource() {
        return mTitleResource;
    }

    public void setmTitleResource(int mTitleResource) {
        this.mTitleResource = mTitleResource;
    }

    public int getmTextResource() {
        return mTextResource;
    }

    public void setmTextResource(int mTextResource) {
        this.mTextResource = mTextResource;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    private int mImageResource;

    public CardItem(int mTitleResource, int mTextResource, int mImageResource) {
        this.mTitleResource = mTitleResource;
        this.mTextResource = mTextResource;
        this.mImageResource = mImageResource;
    }
}