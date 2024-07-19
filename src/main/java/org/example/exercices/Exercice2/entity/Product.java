package org.example.exercices.Exercice2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {

    private UUID id;
    private String name;
    private String category;
    private double price;
}
