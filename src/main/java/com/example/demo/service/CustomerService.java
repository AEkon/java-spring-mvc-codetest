package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

/**
 * CustomerService - Interface to allow for abstraction.
 *
 * @author Alex Ekonomou
 */
public interface CustomerService {

    List<Customer> sort(List<Customer> customers);

}
