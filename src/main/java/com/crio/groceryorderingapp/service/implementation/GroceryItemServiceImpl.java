package com.crio.groceryorderingapp.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.groceryorderingapp.exception.ResourceNotFoundException;
import com.crio.groceryorderingapp.model.GroceryItem;
import com.crio.groceryorderingapp.repository.GroceryItemRespository;
import com.crio.groceryorderingapp.service.GroceryItemService;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

     @Autowired
    private GroceryItemRespository groceryItemRepository;

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        // TODO Auto-generated method stub
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getGroceryItemById(Long id) {
        // TODO Auto-generated method stub
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

    }

    @Override
    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        // TODO Auto-generated method stub
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItemDetails) {
        // TODO Auto-generated method stub
        GroceryItem groceryItem = getGroceryItemById(id);
        groceryItem.setName(groceryItemDetails.getName());
        groceryItem.setPrice(groceryItemDetails.getPrice());
        return groceryItemRepository.save(groceryItem);

    }

    @Override
    public void deleteGroceryItem(Long id) {
        // TODO Auto-generated method stub
        GroceryItem groceryItem = getGroceryItemById(id);
        groceryItemRepository.delete(groceryItem);

    }
    
}
