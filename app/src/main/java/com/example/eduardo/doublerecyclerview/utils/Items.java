package com.example.eduardo.doublerecyclerview.utils;

/**
 * Created by eduardo on 3/9/18.
 */

public class Items {
    private int id;
    private String name;
    private String description;

    public Items(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
