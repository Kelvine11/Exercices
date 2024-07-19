package org.example.exercices.Exercice2.service;

import org.example.exercices.Exercice2.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<UUID, Product> products;

    public ProductService() {
        products = new HashMap<>();

        Product product1 = Product.builder().id(UUID.randomUUID()).name("toto").category("toto").price(2.4).build();
        Product product2 = Product.builder().id(UUID.randomUUID()).name("tata").category("tata").price(2.3).build();
        Product product3 = Product.builder().id(UUID.randomUUID()).name("tato").category("toto").price(5.4).build();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(UUID id) {
        return products.get(id);
    }

        public List<Product> getProductByCategoryAndPriceMax(String category, Double price) {
        List<Product> productsList = new ArrayList<>();
        for (Product product : products.values()) {
            System.out.println(product);
            if (Objects.equals(product.getCategory(), category) && product.getPrice() <= price) {
                System.out.println("Oui    " + product);
               productsList.add(product);
            }
        }
        return productsList;
    }
}
