package com.example.gb_2_notes2.domain;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private final int id;
    private final String title;
    private final String body;
    private final Long time;
    private final String imageUrl;

    public Note(int id, String title, String body, Long time, String imageUrl) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.time = time;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return String.valueOf(getId());
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getTime() {
        return time;
    }

    public String getDate() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date =  new Date(time);
        return dateFormat.format(date);
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
