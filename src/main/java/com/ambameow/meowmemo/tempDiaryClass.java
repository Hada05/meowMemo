package com.ambameow.meowmemo;

public class tempDiaryClass {
    private String title;
    private String content;
    private String mood;
    private String pawsitivity;

    // Constructor
    public tempDiaryClass() {
        // Default constructor
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getPawsitivity() {
        return pawsitivity;
    }

    public void setPawsitivity(String pawsitivity) {
        this.pawsitivity = pawsitivity;
    }

    // Helper method for debugging or testing
    @Override
    public String toString() {
        return "TempEntry [Title: " + title +
                ", Mood: " + mood +
                ", Positivity: " + pawsitivity +
                ", Content: " + content + "]";
    }
}
