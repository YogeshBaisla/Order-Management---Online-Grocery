package com.crio.groceryorderingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "grocery_item")
@Data
public class GroceryItem {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Double quantity;

}
