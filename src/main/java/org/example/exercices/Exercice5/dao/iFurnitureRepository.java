package org.example.exercices.Exercice5.dao;

import org.example.exercices.Exercice5.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iFurnitureRepository extends JpaRepository<Furniture, Integer> {


}
