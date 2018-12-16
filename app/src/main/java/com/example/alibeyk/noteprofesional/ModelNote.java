package com.example.alibeyk.noteprofesional;

import android.widget.TextView;

public class ModelNote {
    private String subject;
    private String describe;
    private String color;
    public static int colorCounter = 0;

    public ModelNote() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColorCounter() {
        return colorCounter;
    }

    public void setColorCounter(int colorCounter) {
        this.colorCounter = colorCounter;
    }
}
