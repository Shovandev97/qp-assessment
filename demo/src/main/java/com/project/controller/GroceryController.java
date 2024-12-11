package com.project.controller;

import com.project.model.Grocery;
import com.project.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
public class GroceryController {
    @Autowired
    private GroceryService groceryService;

    // Admin: Add Grocery
    @PostMapping("/admin/add")
    public ResponseEntity<Grocery> addGrocery(@RequestBody Grocery grocery) {
        return ResponseEntity.ok(groceryService.addGrocery(grocery));
    }

    // Admin: Get All Groceries
    @GetMapping("/admin/list")
    public ResponseEntity<List<Grocery>> getAllGroceries() {
        return ResponseEntity.ok(groceryService.getAllGroceries());
    }

    // Admin: Update Grocery
    @PutMapping("/admin/update/{id}")
    public ResponseEntity<Grocery> updateGrocery(@PathVariable Long id, @RequestBody Grocery grocery) {
        return ResponseEntity.ok(groceryService.updateGrocery(id, grocery));
    }

    // Admin: Delete Grocery
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
        return ResponseEntity.ok("Grocery deleted successfully");
    }

    // User: View Groceries
    @GetMapping("/user/list")
    public ResponseEntity<List<Grocery>> viewGroceries() {
        return ResponseEntity.ok(groceryService.getAllGroceries());
    }
}
