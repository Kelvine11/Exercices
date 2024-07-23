package org.example.exercices.Exercice3.entity;

import jakarta.validation.constraints.*;
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
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank
    private String firstName;
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank
    private String lastName;
    @Min(18)
    @Max(100)
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

}
