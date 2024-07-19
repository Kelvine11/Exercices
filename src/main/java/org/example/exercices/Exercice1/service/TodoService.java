package org.example.exercices.Exercice1.controller.service;

import org.example.exercices.Exercice1.controller.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> todos = new ArrayList<Todo>();

    public TodoService() {
        todos.add(new Todo(1,"toto", "un toto", true));
        todos.add(new Todo(2,"tata", "un tata", false));
    }

    public Todo showTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public List<Todo> getTodos() {
        return todos;
    }

}
