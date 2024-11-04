package com.kanban.kanban.controller;

import com.kanban.kanban.model.TaskModel;
import com.kanban.kanban.repository.TaskRepository;
import com.kanban.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity getAllProduct(){
        var allTask = taskRepository.findAll();
        return ResponseEntity.ok("deu ok");
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task){
        return taskService.save(task);
    }
}
