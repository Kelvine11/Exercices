package org.example.exercices.Exercice6.service;

import org.example.exercices.Exercice6.dao.TodoApiRepository;
import org.example.exercices.Exercice6.entity.TodoApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoApiService {

    private final TodoApiRepository todoApiRepository;

    public TodoApiService(TodoApiRepository todoApiRepository) {
        this.todoApiRepository = todoApiRepository;
    }

    public TodoApi create(TodoApi todoApi) {
        return todoApiRepository.save(todoApi);
    }

    public TodoApi getById(int id) {
        return  todoApiRepository.findById(id).orElse(null);
    }

    public List<TodoApi> getAll() {
        return (List<TodoApi>) todoApiRepository.findAll();
    }

    public TodoApi update(TodoApi newTodoApi) {

        return todoApiRepository.save(newTodoApi);
    }

    public void delete(int id) {
        todoApiRepository.deleteById(id);
    }

    public List<TodoApi> findByValidated(boolean validated) {
        return todoApiRepository.findByValidated(validated);
    }

}
