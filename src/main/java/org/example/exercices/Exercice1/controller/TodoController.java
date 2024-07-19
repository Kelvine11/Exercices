package org.example.exercices.Exercice1.controller;

import org.example.exercices.Exercice1.controller.entity.Todo;
import org.example.exercices.Exercice1.controller.service.TodoService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    @RequestMapping("/todo/{id}")
    public String showTodo(@PathVariable int id, Model model)
    {
       model.addAttribute("todo", this.todoService.showTodo(id) );
       return "todo/show";
    }

    @RequestMapping("/todos")
    public String listTodo(Model model) {
        model.addAttribute("todos", this.todoService.getTodos());
        return "todo/list";
    }

    @RequestMapping("/listJson")
    @ResponseBody
    public List<Todo> getTodo(){
        return this.todoService.getTodos();
    }

}
