package com.example.phoneapp.models;

public class ModelCalls {
    private String name,duration,data;

    public ModelCalls(String number, String duration, String data) {
        this.name = number;
        this.duration = duration;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String number) {
        this.name = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
