package org.example.exercices.Exercice5.service;

import org.example.exercices.Exercice5.dao.iCartItemRepository;
import org.example.exercices.Exercice5.entity.CartItem;
import org.example.exercices.Exercice5.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CartItemService {

    private final FurnitureService furnitureService;
    private iCartItemRepository cartItemRepository;

    public CartItemService(iCartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public void addToCart(Furniture furniture) {

        if (cartItemRepository.existsByFurniture(furniture)) {
            CartItem cartItem = cartItemRepository.findByFurniture(furniture);
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemRepository.save(cartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setFurniture(furniture);
            cartItem.setQuantity(1);
            cartItemRepository.save(cartItem);
        }
    }

    public void removeFromCart(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public void clearCart() {
        List<CartItem> cartItemList = cartItemRepository.findAll();
        HashMap<Furniture, Integer> furnitureHashMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            furnitureHashMap.put(cartItem.getFurniture(), cartItem.getQuantity());
        }
        furnitureService.addStockAfterDeleteAll(furnitureHashMap);
        cartItemRepository.deleteAll();
    }


}
