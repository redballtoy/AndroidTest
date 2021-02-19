package com.example.redballtoy.toolshop_listandlistener;

import androidx.annotation.NonNull;

public class Drill {
    private final String title;
    private final String info;
    private final int imageResourceId;

    public Drill(String title, String info, int imageResourceId) {
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return title+"\n"
                +
                info

                ;
    }
}
