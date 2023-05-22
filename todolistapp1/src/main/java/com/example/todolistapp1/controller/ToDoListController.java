package com.example.todolistapp1.controller;

import com.example.todolistapp1.entity.ToDoListItem;
import com.example.todolistapp1.result.DataResult;
import com.example.todolistapp1.result.Result;
import com.example.todolistapp1.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    public ToDoListController(ToDoListService todoListService) {
        this.toDoListService = todoListService;
    }

    @GetMapping("/todo")
   public DataResult <List<ToDoListItem>> getAllToDo(){
        return this.toDoListService.getAll();
    }

    @PostMapping("/todo")
    public Result addToDo(@RequestBody ToDoListItem toDoListItem){

        return   this.toDoListService.addToDo(toDoListItem);
    }
    @PutMapping("/todo/{updateToDoById}")
    public Result updateToDo(@RequestBody ToDoListItem newToDoListItem)

    {
        return this.toDoListService.updateToDo(newToDoListItem);
    }

    @DeleteMapping("/todo/{deleteToDoById}")

    public Result deleteTodoById(int id) throws Exception {
        return this.toDoListService.deleteToDo(id);
    }
}

