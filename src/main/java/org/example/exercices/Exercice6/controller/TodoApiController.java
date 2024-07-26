package org.example.exercices.Exercice6.controller;

import org.example.exercices.Exercice6.entity.TodoApi;
import org.example.exercices.Exercice6.service.TodoApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toto")
public class TodoApiController {

    private final TodoApiService todoApiService;

    public TodoApiController(TodoApiService todoApiService) {
        this.todoApiService = todoApiService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoApi>> getTodos() {
        return ResponseEntity.ok(todoApiService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<TodoApi> createTodo(@RequestBody TodoApi todoApi) {
        TodoApi createdTodoApi = todoApiService.create(todoApi);
        return ResponseEntity.ok(createdTodoApi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoApi> getTodoById(@PathVariable int id) {
        return ResponseEntity.ok(todoApiService.getById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoApiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<TodoApi> updateTodo(@PathVariable int id, @RequestBody TodoApi todoApi) {
        todoApiService.update(todoApi);
        return ResponseEntity.ok(todoApi);
    }

    @GetMapping("/todoByValidated/{validated}")
    public ResponseEntity<List<TodoApi>> findByValidated(@PathVariable boolean validated) {
        return ResponseEntity.ok(todoApiService.findByValidated(validated));
    }
}
