package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * CustomerService Implementation.
 *
 * @author Alex Ekonomou
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> sort(List<Customer> customers) {
        if(customers == null) {
            throw new IllegalArgumentException("Make sure list of Customers is not null.");
        }
        Collections.sort(customers);
        return customers;
    }
}
