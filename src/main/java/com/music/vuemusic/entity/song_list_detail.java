package com.music.vuemusic.entity;

public class song_list_detail {
    private int userId;
    private String name;
    private int type;
    private String song_detail;

    public String getSong_detail() {
        return song_detail;
    }

    public void setSong_detail(String song_detail) {
        this.song_detail = song_detail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
