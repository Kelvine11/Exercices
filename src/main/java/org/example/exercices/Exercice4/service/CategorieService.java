package org.example.exercices.Exercice4.service;

import org.example.exercices.Exercice4.entity.Categorie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategorieService {

    private List<Categorie> categories;

    public CategorieService() {
        categories = new ArrayList<Categorie>();
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void addCategorie(Categorie categorie) {
        if (categories.isEmpty()) {
            categories.add(categorie);
        } else {
            for (int i = 0; i < categories.size(); i++) {
                if (categorie.getId().equals(categories.get(i).getId())) {
                    categories.set(i, categorie);
                } else categories.add(categorie);

            }
        }
    }

    public void removeCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public Categorie getCategorieById(UUID id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
