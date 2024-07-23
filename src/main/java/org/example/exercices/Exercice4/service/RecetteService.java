package org.example.exercices.Exercice4.service;

import org.example.exercices.Exercice4.entity.Recette;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecetteService {

    private CategorieService categorieService;
    private List<Recette> recettes;

    public RecetteService(CategorieService categorieService) {
        recettes = new ArrayList<Recette>();
        this.categorieService = categorieService;
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void addRecette(Recette recette) {
        recette.setCategorie(categorieService.getCategorieById(recette.getCategorie().getId()));
        if (recettes.isEmpty()) {
            recettes.add(recette);
        } else {
            for (int i = 0; i < recettes.size(); i++) {
                if (recette.getId().equals(recettes.get(i).getId())) {
                    recettes.set(i, recette);
                } else recettes.add(recette);

            }
        }
    }

    public void removeRecette(Recette recette) {
        recettes.remove(recette);
    }

    public Recette getRecetteById(UUID id) {
        return recettes.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

}
