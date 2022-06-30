package com.example.wfm_traffic.model;

public class NavItem {
    private String item;
    private String icon;

    public NavItem(String item, String icon) {
        this.item = item;
        this.icon = icon;
    }

    public NavItem() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
