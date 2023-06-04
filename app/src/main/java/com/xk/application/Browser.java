package com.xk.application;

/**
 * @Author xk
 * @Date 2023/04/19 00:03
 */
public class Browser {
    private String name;
    private String mdate;
    private int icon;
    private int icon1;
    private int icon2;

    public Browser(String name, int icon, int icon1, int icon2, String mdate) {
        this.name = name;
        this.icon = icon;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.mdate = mdate;
    }


    public int getIcon1() {
        return icon1;
    }

    public int getIcon2() {
        return icon2;
    }


    public String getMdate() {
        return mdate;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
