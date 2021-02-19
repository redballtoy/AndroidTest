package com.example.redballtoy.recyclerviewsumin_notes.model;

//сласс содержащий всю информацию о заметке
public class Note {
    private final String title;
    private final String description;
    private final String dayWeekly;
    private final int priority;

    public Note(String title, String description, String dayWeekly, int priority) {
        this.title = title;
        this.description = description;
        this.dayWeekly = dayWeekly;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDayWeekly() {
        return dayWeekly;
    }

    public int getPriority() {
        return priority;
    }
}
