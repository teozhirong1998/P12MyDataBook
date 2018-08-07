package com.example.a16022635.p12_mydatabook;

import java.io.Serializable;

public class Title implements Serializable {
    private String title;

    public Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
