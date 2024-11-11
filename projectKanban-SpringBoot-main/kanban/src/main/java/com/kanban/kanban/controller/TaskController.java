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

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task){
        task.setStatus("Fazer");
        return taskService.save(task);
    }

    @GetMapping("/todo")
    public List<TaskModel> searchToDo(){
        return taskService.findToDo();
    }

    @GetMapping("/doing")
    public List<TaskModel> searchDoing(){
        return taskService.findDoing();
    }

    @GetMapping("/done")
    public List<TaskModel> searchDone(){
        return taskService.findDone();
    }

    @PutMapping("/{id}/move")
    public ResponseEntity<String> changeStatus(@PathVariable Long id){
        TaskModel movedTask = taskService.changeTaskStats(id);
        return ResponseEntity.ok("Status da tarefa alterado com sucesso!");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        TaskModel deleteTask = taskService.deleteById(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskModel updateTask){
        TaskModel t = taskService.updatedTask(id, updateTask);
        return ResponseEntity.ok("Tarefa atualizada com sucesso");
    }
}
