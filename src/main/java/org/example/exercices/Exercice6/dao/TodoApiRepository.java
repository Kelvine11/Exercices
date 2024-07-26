package org.example.exercices.Exercice6.dao;

import org.example.exercices.Exercice6.entity.TodoApi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoApiRepository extends CrudRepository<TodoApi, Integer> {
    List<TodoApi> findByValidated(boolean validated);
}
