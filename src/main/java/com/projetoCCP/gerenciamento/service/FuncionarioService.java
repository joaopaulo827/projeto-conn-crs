/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoCCP.gerenciamento.service;

import com.projetoCCP.gerenciamento.model.FuncionarioBean;
import com.projetoCCP.gerenciamento.repository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioDAO repository;
    
    public List<FuncionarioBean>lerTodos(){
        return repository.lerTodos();
    }
    public FuncionarioBean LerPorId(int id){
        return repository.LerPorId(id);
    }
    public void atualizar(FuncionarioBean funcionario){
        repository.atualizar(funcionario);
    }
    public void criar(FuncionarioBean funcionario){
        repository.criar(funcionario);
    }
}
