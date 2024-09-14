package com.crio.groceryorderingapp.service.implementation;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.groceryorderingapp.dto.OrderRequest;
import com.crio.groceryorderingapp.exception.ResourceNotFoundException;
import com.crio.groceryorderingapp.model.Customer;
import com.crio.groceryorderingapp.model.GroceryItem;
import com.crio.groceryorderingapp.model.Order;
import com.crio.groceryorderingapp.repository.CustomerRepository;
import com.crio.groceryorderingapp.repository.GroceryItemRespository;
import com.crio.groceryorderingapp.repository.OrderRepository;
import com.crio.groceryorderingapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GroceryItemRespository groceryItemRespository;


    @Override
    public List<Order> getAllOrders() {
        
        // TODO Auto-generated method stub
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        // TODO Auto-generated method stub
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
        List<GroceryItem> groceryItems = groceryItemRespository.findAllById(orderRequest.getGroceryItemIds());
        
        if (groceryItems.size() != orderRequest.getGroceryItemIds().size()) {
            throw new ResourceNotFoundException("One or more products not found");
        }

        Order order = new Order();

        order.setCustomer(customer);
        order.setGroceryItem(groceryItems);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);

    }

    @Override
    public void deleteOrder(Long id) {
        // TODO Auto-generated method stub
        Order order = getOrderById(id);
        orderRepository.delete(order);

    }
    
}
