package com.haanhgs.uibasic.model;

public class Model {

    public static final float SIZE = 15f;
    private int count;
    private float size = 15;
    private boolean show = true;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
