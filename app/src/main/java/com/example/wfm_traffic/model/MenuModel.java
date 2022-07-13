package com.example.wfm_traffic.model;

public class MenuModel {
    public int drawableId;
    public String menuName;
    public boolean hasChildren, isGroup;

    public MenuModel(int id, String menuName, boolean hasChildren, boolean isGroup) {
        this.drawableId = id;
        this.menuName = menuName;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
    }
}
