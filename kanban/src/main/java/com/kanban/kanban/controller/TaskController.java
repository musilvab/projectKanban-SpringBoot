package com.kanban.kanban.controller;

import com.kanban.kanban.model.TaskModel;
import com.kanban.kanban.repository.TaskRepository;
import com.kanban.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task){
        task.setStatus("Fazer");
        return taskService.save(task);
    }

    @GetMapping
    public List<TaskModel> searchTask() {
       return taskService.findAll();
    }

}
