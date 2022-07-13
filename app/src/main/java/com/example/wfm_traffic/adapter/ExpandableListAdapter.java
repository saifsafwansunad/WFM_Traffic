package com.example.wfm_traffic.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.model.MenuModel;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<MenuModel> listDataHeader;
    private HashMap<MenuModel, List<MenuModel>> listDataChild;

    public ExpandableListAdapter(Context context, List<MenuModel> listDataHeader,
                                 HashMap<MenuModel, List<MenuModel>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public MenuModel getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = getChild(groupPosition, childPosition).menuName;
        final int childIcon = getChild(groupPosition, childPosition).drawableId;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_child, null);
        }

        TextView txtListChild = convertView
                .findViewById(R.id.tv_child_name);
        ImageView txtListChildI = convertView
                .findViewById(R.id.iv_icon1);

        txtListChild.setText(childText);
        txtListChildI.setImageDrawable(context.getDrawable(childIcon));
//        txtListChild.setCompoundDrawablesWithIntrinsicBounds(childIcon,0,0,0);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if (this.listDataChild.get(this.listDataHeader.get(groupPosition)) == null)
            return 0;
        else
            return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                    .size();
    }

    @Override
    public MenuModel getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).menuName;
        int headerIcon = getGroup(groupPosition).drawableId;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_header, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.tv_name);
        ImageView ivIcon = convertView.findViewById(R.id.iv_icon);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        ivIcon.setImageDrawable(context.getDrawable(headerIcon));
//        lblListHeader.setCompoundDrawablesWithIntrinsicBounds(headerIcon,0,0,0);
        ImageView ivArrow = (ImageView) convertView.findViewById(R.id.iv_arrow);

        // check if GroupView is expanded and set imageview for expand/collapse-action
        if (getChildrenCount(groupPosition) == 0)
        {
            ivArrow.setVisibility(View.INVISIBLE);
        }else {
            ivArrow.setVisibility(View.VISIBLE);
        }
//        if (groupPosition == 0 | groupPosition == 4 | groupPosition == 6)
//        {
//            imgExpandCollapse.setVisibility(View.INVISIBLE);
//        }else {
//            imgExpandCollapse.setVisibility(View.VISIBLE);
//        }

        if(isExpanded){
            ivArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        }
        else {
            ivArrow.setImageResource(R.drawable.icon_right);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
