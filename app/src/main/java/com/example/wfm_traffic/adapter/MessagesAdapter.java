package com.example.wfm_traffic.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.model.MessagesModel;
import com.example.wfm_traffic.model.TaskModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {
    private ArrayList<MessagesModel> messagesModelArrayList;
    private Context context;

    public MessagesAdapter(ArrayList<MessagesModel> messagesModelArrayList, Context context) {
        this.messagesModelArrayList = messagesModelArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MessagesAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.messsages_layout, parent, false);
        return new MessagesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessagesAdapter.ViewHolder holder, int position) {
        holder.textViewMsgName.setText(messagesModelArrayList.get(position).getSenderName());
        holder.textViewMsgCity.setText(messagesModelArrayList.get(position).getSenderCity());
        holder.textViewMsgCompany.setText(messagesModelArrayList.get(position).getSendercompany());
        holder.textViewMsgJob.setText(messagesModelArrayList.get(position).getSendjob());
        Picasso.get()
                .load(messagesModelArrayList.get(position).getMsgImage())
                .into(holder.imageViewMsgProfile);


        holder.imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.imageViewMenu);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_unread:
                                Toast.makeText(context, "Marked as Unread", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_delete:
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_edit:
                                Toast.makeText(context, "Saved as Draft", Toast.LENGTH_SHORT).show();


                            default:
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (messagesModelArrayList != null) ? messagesModelArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewMsgName,textViewMsgJob,textViewMsgCity,textViewMsgCompany;
        ImageView imageViewMsgProfile,imageViewMenu;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewMsgName=itemView.findViewById(R.id.msgname_txtview);
            textViewMsgJob=itemView.findViewById(R.id.msgjob_txtview);
            textViewMsgCity=itemView.findViewById(R.id.msgcity_txtview);
            textViewMsgCompany=itemView.findViewById(R.id.msgcompany_txtview);
            imageViewMsgProfile=itemView.findViewById(R.id.msg_imgview);
            imageViewMenu=itemView.findViewById(R.id.messages_munu);

        }
    }
}

