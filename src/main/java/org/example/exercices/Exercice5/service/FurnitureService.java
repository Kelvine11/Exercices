package org.example.exercices.Exercice5.service;

import org.example.exercices.Exercice5.dao.iFurnitureRepository;
import org.example.exercices.Exercice5.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FurnitureService {

    private iFurnitureRepository furnitureRepository;

    public FurnitureService(iFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public Furniture getFurnitureById(int id) {
       return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteFurnitureById(int id) {
        furnitureRepository.deleteById(id);
    }

    public void updateStock(Furniture furniture) {
        furniture.setStock(furniture.getStock() - 1);
        furnitureRepository.save(furniture);
    }

    public void addStock(Furniture furniture, int quantity) {
        furniture.setStock(furniture.getStock() + quantity);
        furnitureRepository.save(furniture);
    }

    public void addStockAfterDeleteAll(HashMap<Furniture, Integer> furnitureHashMap) {
        for (Map.Entry<Furniture, Integer> entry : furnitureHashMap.entrySet()) {
            Furniture furniture = entry.getKey();
            Integer quantity = entry.getValue();
            furniture.setStock(furniture.getStock() + quantity);
            furnitureRepository.save(furniture);
        }
    }

}
