package com.example.wfm_traffic.model;

public class MenuModel {
    public int id;
    public String menuName;
    public boolean hasChildren, isGroup;

    public MenuModel(int id, String menuName, boolean hasChildren, boolean isGroup) {
        this.id = id;
        this.menuName = menuName;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
    }
}
