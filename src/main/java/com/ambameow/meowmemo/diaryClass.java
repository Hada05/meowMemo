package com.ambameow.meowmemo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

public class diaryClass {

    private String title;
    private String content;
    private String mood;
    private String pawsitivity;
    // Constructor

    public diaryClass() {
        // Optional: Initialize default values if needed
        this.title = "";
        this.content = "";
        this.mood = "";
        this.pawsitivity = "";
    }
    public diaryClass(String title, String content, String mood, String pawsitivity) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.pawsitivity = pawsitivity;
    }

    // Getters and setters with annotations
    @JsonProperty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @JsonProperty
    public String getPawsitivity() {
        return pawsitivity;
    }

    public void setPawsitivity(String pawsitivity) {
        this.pawsitivity = pawsitivity;
    }

    // Helper method for debugging or testing
    @Override
    public String toString() {
        return "Diary Entry [Title: " + title +
                ", Mood: " + mood +
                ", Positivity: " + pawsitivity +
                ", Content: " + content + "]";
    }
}
