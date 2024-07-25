package org.example.exercices.Exercice5.dao;

import org.example.exercices.Exercice5.entity.CartItem;
import org.example.exercices.Exercice5.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCartItemRepository extends JpaRepository<CartItem, Integer> {

    boolean existsByFurniture(Furniture furniture);

    CartItem findByFurniture(Furniture furniture);


}
