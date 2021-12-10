package com.trifun.organizator;

public class ToDo {

    private String date, time, activity;

    public ToDo(String date, String time, String activity) {
        this.date = date;
        this.time = time;
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
