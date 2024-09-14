package com.crio.groceryorderingapp.service;

import java.util.List;

import com.crio.groceryorderingapp.model.GroceryItem;

public interface GroceryItemService {
    List<GroceryItem> getAllGroceryItems();
    GroceryItem getGroceryItemById(Long id);
    GroceryItem createGroceryItem(GroceryItem groceryItem);
    GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem);
    void deleteGroceryItem(Long id);

    
}
