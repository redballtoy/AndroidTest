package com.example.redballtoy.seekbarandlistview_multtable;

public class MultItem {
    private int k;
    private int value;

    public MultItem(int k, int value) {
        this.k = k;
        this.value = value;
    }
    public MultItem() {
        this.k = 0;
        this.value = 0;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
