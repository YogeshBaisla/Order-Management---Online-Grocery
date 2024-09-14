package com.crio.groceryorderingapp.service;

import java.util.List;

import com.crio.groceryorderingapp.dto.OrderRequest;
import com.crio.groceryorderingapp.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderRequest orderRequest);
    void deleteOrder(Long id);
}