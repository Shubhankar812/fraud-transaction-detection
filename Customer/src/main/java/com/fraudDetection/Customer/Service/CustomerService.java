package com.fraudDetection.Customer.Service;

import com.fraudDetection.Customer.Entity.Customer;
import com.fraudDetection.Customer.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository cr) {
        this.customerRepository = cr;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {

        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with id: " + customerId));

        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }
}
