package org.example.exercices.Exercice5.controller;

import jakarta.validation.Valid;
import org.example.exercices.Exercice5.entity.Furniture;
import org.example.exercices.Exercice5.service.CartItemService;
import org.example.exercices.Exercice5.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FurnitureController {

    private FurnitureService furnitureService;
    private CartItemService cartItemService;

    public FurnitureController(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/exercice5/")
    public String index(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "exercice5/furnitures";
    }

    @GetMapping("/exercice5/form")
    public String form(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "exercice5/form";
    }

    @PostMapping("/exercice5/form")
    public String formSubmit(@Valid @ModelAttribute("furniture") Furniture furniture, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "exercice5/form";
        }
        furnitureService.saveFurniture(furniture);
        return "redirect:/exercice5/";
    }

    @GetMapping("/exercice5/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "exercice5/form";
    }

    @GetMapping("/exercice5/delete/{id}")
    public String delete(@PathVariable int id) {
        furnitureService.deleteFurnitureById(id);
        return "redirect:/exercice5/";
    }

    @GetMapping("/exercice5/addCart/{id}")
    public String addCart(@PathVariable int id, Model model) {

        Furniture furniture = furnitureService.getFurnitureById(id);
        if (furniture.getStock() > 0) {
            cartItemService.addToCart(furniture);
            furnitureService.updateStock(furniture);
        }
        return "redirect:/exercice5/cart";
    }

}
