package org.example.exercices.Exercice4.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Recette {

    private UUID id;
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank
    private String nom;
    @NotNull(message = "Ce champ doit être rempli !")
    @NotNull
    private String ingedients;
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank
    private String instructions;
    private Categorie categorie;

}
