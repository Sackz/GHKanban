package com.ppena.ghkanban.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

import static android.content.ContentValues.TAG;

public class Issue implements Serializable {

    String title;
    String description;
    String info;

    public Issue(String title, String description, String info) {
        this.title = title;
        this.description = description;
        this.info = info;
    }

    protected Issue(Parcel in) {
        title = in.readString();
        description = in.readString();
        info = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }




}
