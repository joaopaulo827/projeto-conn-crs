/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoCCP.gerenciamento.controller;
import com.projetoCCP.gerenciamento.model.FuncionarioBean;
import com.projetoCCP.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aluno
 */
@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;
    @GetMapping("/funcionarios")
 public String getFuncionarios(Model model){
     List<FuncionarioBean> lista = service.lerTodos();
     model.addAttribute("lista",lista);
    return "funcionarios";
}
 
 @GetMapping("/perfil")
 public String perfil(@RequestParam int id, Model model){
     FuncionarioBean funcionario= service.LerPorId(id);
     model.addAttribute("funcionario",funcionario);
   return("perfil");  
 }
 
 @GetMapping("/criar-novo")
 public String CriarNovo(Model model){
     FuncionarioBean funcionario = new FuncionarioBean();
       model.addAttribute("funcionario", funcionario);     
     return "criar-novo";
 
 }
 
@PostMapping("/salvar")
public String salvarDados(@ModelAttribute FuncionarioBean funcionario){
    service.atualizar(funcionario);
    return "redirect:/funcionarios";        
    }

@PutMapping("/atualizar")
public String atualizarDados(@ModelAttribute FuncionarioBean funcionario){
    service.atualizar(funcionario);
    return "redirect:/funcionarios";  
    }

@PostMapping("/criar")
public String CriarDados(@ModelAttribute FuncionarioBean funcionario){
    service.criar(funcionario);
    return "redirect:/funcionarios";
}
}