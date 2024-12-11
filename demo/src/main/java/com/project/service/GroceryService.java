package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.Grocery;
import com.project.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {
    @Autowired
    private GroceryRepository groceryRepository;

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Optional<Grocery> getGroceryById(Long id) {
        return groceryRepository.findById(id);
    }

    public void deleteGrocery(Long id) {
        groceryRepository.deleteById(id);
    }

    public Grocery updateGrocery(Long id, Grocery updatedGrocery) {
        return groceryRepository.findById(id).map(grocery -> {
            grocery.setName(updatedGrocery.getName());
            grocery.setPrice(updatedGrocery.getPrice());
            grocery.setQuantity(updatedGrocery.getQuantity());
            return groceryRepository.save(grocery);
        }).orElseThrow(() -> new RuntimeException("Grocery not found"));
    }
}
