package com.example.wfm_traffic.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.wfm_traffic.CardItem;
import com.example.wfm_traffic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        if (position==0){
            cardView.setCardBackgroundColor(Color.parseColor("#7367F0"));
        }
        else if (position==1){
            cardView.setCardBackgroundColor(Color.parseColor("#28A745"));

        }
        else if (position==2){
            cardView.setCardBackgroundColor(Color.parseColor("#17A2B8"));

        }
        else if (position==3){
            cardView.setCardBackgroundColor(Color.parseColor("#FFC107"));

        }
        else if (position==4){
            cardView.setCardBackgroundColor(Color.parseColor("#DC3545"));

        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        ImageView imageViewCard = (ImageView) view.findViewById(R.id.cardviw_imageview);

        titleTextView.setText(item.getmTitleResource());
        contentTextView.setText(item.getmTextResource());
        Picasso.get().load(item.getmImageResource()).into(imageViewCard);


    }

}