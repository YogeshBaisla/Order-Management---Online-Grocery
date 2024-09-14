package com.crio.groceryorderingapp.service.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.groceryorderingapp.exception.ResourceNotFoundException;
import com.crio.groceryorderingapp.model.Customer;
import com.crio.groceryorderingapp.repository.CustomerRepository;
import com.crio.groceryorderingapp.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        // TODO Auto-generated method stub
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

    }

    @Override
    public Customer createCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        // TODO Auto-generated method stub
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        return customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Long id) {
        // TODO Auto-generated method stub
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);

    }
    
}
