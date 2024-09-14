package com.crio.groceryorderingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.groceryorderingapp.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
