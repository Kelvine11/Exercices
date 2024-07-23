package org.example.exercices.Exercice4.controller;

import jakarta.validation.Valid;
import org.example.exercices.Exercice4.entity.Categorie;
import org.example.exercices.Exercice4.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CategorieController {

    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/exercice4/index")
    public String index() {
        return "exercice4/index";
    }

    @GetMapping("/exercice4/categorie/liste")
    public String list(Model model) {
        model.addAttribute("categories", categorieService.getCategories());
        return "exercice4/categorie/liste";
    }

    @GetMapping("/exercice4/categorie/add")
    public String add(Model model) {
        Categorie categorie = new Categorie();
        categorie.setId(UUID.randomUUID());
        model.addAttribute("categorie", categorie);
        return "exercice4/categorie/add";
    }

    @PostMapping("/exercice4/categorie/add")
    public String add(@Valid @ModelAttribute("categorie") Categorie categorie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "exercice4/categorie/add";
        } else {
            categorieService.addCategorie(categorie);
            return "redirect:/exercice4/categorie/liste";
        }
    }

    @GetMapping("/exercice4/categorie/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("categorie", categorieService.getCategorieById(id));
        return "exercice4/categorie/add";
    }

    @GetMapping("/exercice4/categorie/delete/{id}")
    public String delete(@PathVariable UUID id) {
        categorieService.removeCategorie(categorieService.getCategorieById(id));
        return "redirect:/exercice4/categorie/liste";
    }


}
