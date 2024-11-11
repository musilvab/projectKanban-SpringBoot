package com.kanban.kanban.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descricao;
    private String status;

    public TaskModel(long id, String nome, String descricao, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public TaskModel() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Produto {" +
                "id = " + id +
                ", nome = " + nome +
                ", descrição = " + descricao +
                ", status = " + status +
                "}";
    }


}
