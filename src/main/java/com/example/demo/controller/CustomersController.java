package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @Async
    @PostMapping(value = "/sorted")
    public CompletableFuture<List<Customer>> sort(@RequestBody ArrayList<Customer> customers) {
        return CompletableFuture.completedFuture(customerService.sort(customers));
    }


}
