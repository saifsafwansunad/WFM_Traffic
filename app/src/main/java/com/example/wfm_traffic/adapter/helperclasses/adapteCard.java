package com.example.wfm_traffic.adapter.helperclasses;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfm_traffic.R;

import java.util.ArrayList;

public class adapteCard extends RecyclerView.Adapter<adapteCard.PhoneViewHold>  {

    ArrayList<cardmodel> phoneLaocations;
    final private ListItemClickListener mOnClickListener;

    public adapteCard(ArrayList<cardmodel> phoneLaocations, ListItemClickListener listener) {
        this.phoneLaocations = phoneLaocations;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewcard_layout, parent, false);
        return new PhoneViewHold(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        cardmodel cardmodel = phoneLaocations.get(position);
        holder.image.setImageResource(cardmodel.getImage());
        holder.cardvalue.setText(cardmodel.getCardValue());
        holder.title.setText(cardmodel.getTitle());
        if (position==0){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#7367F0"));

        }
        else if (position==1){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#28A745"));


        }
        else if (position==2){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#17A2B8"));


        }
        else if (position==3){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFC107"));


        }
        else if (position==4){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#DC3545"));


        }
    }

    @Override
    public int getItemCount() {
        return phoneLaocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image;
        TextView title,cardvalue;
        RelativeLayout relativeLayout;


        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            image = itemView.findViewById(R.id.slider_image);
            title = itemView.findViewById(R.id.card_title);
            cardvalue = itemView.findViewById(R.id.card_value);

            relativeLayout = itemView.findViewById(R.id.slider_background_color);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
        }
    }

}