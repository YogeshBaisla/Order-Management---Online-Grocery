package com.crio.groceryorderingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.groceryorderingapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    List<Customer> findByEmail(String email);
    
}
