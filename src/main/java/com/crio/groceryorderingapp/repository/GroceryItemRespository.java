package com.crio.groceryorderingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.groceryorderingapp.model.GroceryItem;

public interface GroceryItemRespository extends JpaRepository<GroceryItem,Long> {
    
}
