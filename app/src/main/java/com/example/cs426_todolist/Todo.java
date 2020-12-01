package com.example.cs426_todolist;

public class Todo {
    private String name;
    private String description;
    private int iconIndex;

    public Todo(String name, String description, int iconIndex) {
        this.name = name;
        this.description = description;
        this.iconIndex = iconIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIconIndex() {
        return iconIndex;
    }

    public void setIconIndex(int iconIndex) {
        this.iconIndex = iconIndex;
    }
}
