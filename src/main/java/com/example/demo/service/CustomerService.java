package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface CustomerService {

    @Async
    void sortByDueTime(List<Customer> customers);

}
