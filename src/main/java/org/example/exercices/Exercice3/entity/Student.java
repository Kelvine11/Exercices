package org.example.exercices.Exercice3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
