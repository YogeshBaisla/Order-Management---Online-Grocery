package com.crio.groceryorderingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.groceryorderingapp.model.GroceryItem;
import com.crio.groceryorderingapp.service.GroceryItemService;

@RestController
@RequestMapping("/api/products")
public class GroceryItemController {
     @Autowired
    private GroceryItemService groceryItemService;
    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getProductById(@PathVariable Long id) {
        GroceryItem groceryItem = groceryItemService.getGroceryItemById(id);
        return ResponseEntity.ok(groceryItem);
    }

    @PostMapping
    public GroceryItem createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.createGroceryItem(groceryItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateProduct(@PathVariable Long id, @RequestBody GroceryItem groceryItemDetails) {
        GroceryItem updatedGroceryItem = groceryItemService.updateGroceryItem(id, groceryItemDetails);
        return ResponseEntity.ok(updatedGroceryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.ok().build();
    }


}
