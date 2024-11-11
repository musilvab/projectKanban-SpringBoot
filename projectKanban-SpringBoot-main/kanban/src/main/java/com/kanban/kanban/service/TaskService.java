package com.kanban.kanban.service;

import com.kanban.kanban.model.TaskModel;
import com.kanban.kanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> findAll(){
        return taskRepository.findAll();
    }

    public TaskModel save(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel deleteById(Long id){
        taskRepository.deleteById(id);
        return null;
    }

    public List<TaskModel> findToDo(){
        List<TaskModel> listaAux = new ArrayList<>();
        for(TaskModel t : taskRepository.findAll()){
            if(Objects.equals(t.getStatus(), "Fazer")){
                listaAux.add(t);
            }
        }
        return listaAux;
    }

    public List<TaskModel> findDoing(){
        List<TaskModel> listaAux = new ArrayList<>();
        for(TaskModel t : taskRepository.findAll()){
            if(Objects.equals(t.getStatus(), "Fazendo")){
                listaAux.add(t);
            }
        }
        return listaAux;
    }

    public List<TaskModel> findDone(){
        List<TaskModel> listaAux = new ArrayList<>();
        for(TaskModel t : taskRepository.findAll()){
            if(Objects.equals(t.getStatus(), "Feito")){
                listaAux.add(t);
            }
        }
        return listaAux;
    }


    public TaskModel changeTaskStats(@PathVariable Long id){
        TaskModel t = taskRepository.findById(id).orElseThrow();
                switch (t.getStatus()) {
                    case "Fazer":
                        t.setStatus("Fazendo");
                        break;
                    case "Fazendo":
                        t.setStatus("Feito");
                        break;
                }
        TaskModel taskChange = taskRepository.save(t);
        return taskChange;
    }

    @PutMapping("/tasks/{id}")
    public TaskModel updatedTask(@PathVariable Long id, @RequestBody TaskModel upTask) {
        TaskModel task = taskRepository.findById(id).orElseThrow();

        if (upTask.getNome() != null) {
            task.setNome(upTask.getNome());
        }
        if (upTask.getDescricao() != null) {
            task.setDescricao(upTask.getDescricao());
        }
        
        return taskRepository.save(task);
    }

}
