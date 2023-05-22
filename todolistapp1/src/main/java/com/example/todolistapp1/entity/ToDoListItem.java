package com.example.todolistapp1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "ToDoListItem" )
public class ToDoListItem {

    @Id
    private int id;
    private String description;

    public ToDoListItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ToDoListItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoListItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

