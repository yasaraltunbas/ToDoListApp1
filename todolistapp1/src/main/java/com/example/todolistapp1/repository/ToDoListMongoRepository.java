package com.example.todolistapp1.repository;

import com.example.todolistapp1.entity.ToDoListItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoListMongoRepository extends MongoRepository<ToDoListItem,Integer> {
}
