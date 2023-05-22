package com.example.todolistapp1.service;

import com.example.todolistapp1.entity.ToDoListItem;
import com.example.todolistapp1.repository.ToDoListMongoRepository;
import com.example.todolistapp1.result.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    public ToDoListMongoRepository toDoListMongoRepository;

    public ToDoListService(ToDoListMongoRepository toDoListMongoRepository) {
        this.toDoListMongoRepository = toDoListMongoRepository;
    }

    public DataResult<List<ToDoListItem>> getAll() {

        try {
            return new SuccessDataResult<List<ToDoListItem>>
                    (this.toDoListMongoRepository.findAll(),"Yapılacaklar Listesi Listelendi");
        }
        catch (Exception e){
            return new ErrorDataResult("Yapılacaklar Listesi listenemedi.");
        }
    }

    public Result addToDo(ToDoListItem todoListItem) {
        this.toDoListMongoRepository.save(todoListItem);
        return new SuccessResult("Yapılacaklar Listesine eklendi.");    }

    public Result updateToDo(ToDoListItem newToDoListItem) {
        Optional<ToDoListItem> todoListItem = toDoListMongoRepository.findById(newToDoListItem.getId());
        ToDoListItem foundToDoList = todoListItem.get();
        foundToDoList.setDescription(newToDoListItem.getDescription());
        toDoListMongoRepository.save(foundToDoList);
        return new SuccessResult("Yapılacaklar Listesi Güncellendi");
    }

    public Result deleteToDo(int id) {
        Optional<ToDoListItem> product = toDoListMongoRepository.findById(id);
        toDoListMongoRepository.deleteById(id);
        return new SuccessResult("Yapılacak iş kaldırıldı.");


    }
}