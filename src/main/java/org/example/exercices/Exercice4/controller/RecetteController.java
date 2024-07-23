package org.example.exercices.Exercice4.controller;

import jakarta.validation.Valid;
import org.example.exercices.Exercice4.entity.Recette;
import org.example.exercices.Exercice4.service.CategorieService;
import org.example.exercices.Exercice4.service.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class RecetteController {

    private RecetteService recetteService;
    private CategorieService categorieService;

    public RecetteController(RecetteService recetteService, CategorieService categorieService) {
        this.recetteService = recetteService;
        this.categorieService = categorieService;
    }

    @GetMapping("/exercice4/recette/liste")
    public String list(Model model) {
        model.addAttribute("recettes", recetteService.getRecettes());
        return "exercice4/recette/liste";
    }

    @GetMapping("/exercice4/recette/add")
    public String add(Model model) {
        Recette recette = new Recette();
        recette.setId(UUID.randomUUID());
        model.addAttribute("recette", recette);
        model.addAttribute("categories", categorieService.getCategories());
        return "exercice4/recette/add";
    }

    @PostMapping("/exercice4/recette/add")
    public String add(@Valid @ModelAttribute("recette") Recette recette, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "exercice4/recette/add";
        } else {
            recetteService.addRecette(recette);
            return "redirect:/exercice4/recette/liste";
        }
    }

    @GetMapping("/exercice4/recette/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("recette", recetteService.getRecetteById(id));
        model.addAttribute("categories", categorieService.getCategories());
        return "exercice4/recette/add";
    }

    @GetMapping("/exercice4/recette/delete/{id}")
    public String delete(@PathVariable UUID id) {
        recetteService.removeRecette(recetteService.getRecetteById(id));
        return "redirect:/exercice4/recette/liste";
    }

}
