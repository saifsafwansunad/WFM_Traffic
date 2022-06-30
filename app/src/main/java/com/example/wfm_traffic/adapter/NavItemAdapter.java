package com.example.wfm_traffic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.model.NavItem;

import java.util.ArrayList;
import java.util.List;

public class NavItemAdapter extends ArrayAdapter<NavItem> {


    // View lookup cache
    private static class ViewHolder {
        TextView name;
        ImageView drawable;
    }

    public NavItemAdapter(@NonNull Context context, @NonNull ArrayList<NavItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        NavItem user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_nav_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.lblListHeader);
            viewHolder.drawable = (ImageView) convertView.findViewById(R.id.header_imageview);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.name.setText(user.getItem());
//        viewHolder.home.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
