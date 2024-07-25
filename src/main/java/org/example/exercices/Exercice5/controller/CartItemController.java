package org.example.exercices.Exercice5.controller;

import org.example.exercices.Exercice5.entity.CartItem;
import org.example.exercices.Exercice5.service.CartItemService;
import org.example.exercices.Exercice5.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartItemController {

    private CartItemService cartItemService;
    private FurnitureService furnitureService;

    public CartItemController(CartItemService cartItemService, FurnitureService furnitureService) {
        this.cartItemService = cartItemService;
        this.furnitureService = furnitureService;
    }

    @GetMapping("/exercice5/cart")
    public String cart(Model model) {
        model.addAttribute("cartItems", cartItemService.getAllCartItems());
        return "exercice5/cart";
    }

    @GetMapping("/exercice5/cart/delete/{id}")
    public String deleteCartItem(@PathVariable int id, Model model) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        cartItemService.removeFromCart(cartItem);
        furnitureService.addStock(cartItem.getFurniture(), cartItem.getQuantity());
        return "redirect:/exercice5/cart";
    }

    @GetMapping("/exercice5/cart/deleteAll")
    public String deleteAllCartItems() {
        cartItemService.clearCart();
        return "redirect:/exercice5/";
    }

}
