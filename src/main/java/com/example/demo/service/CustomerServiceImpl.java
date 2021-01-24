package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void sortByDueTime(List<Customer> customers) {
        Collections.sort(customers);
    }
}
