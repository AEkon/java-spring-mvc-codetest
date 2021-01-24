package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/sorted")
    public CollectionModel<Customer> sort(@RequestBody ArrayList<Customer> customers) {
        //todo: sort in service class so it can be async
        customerService.sortByDueTime(customers);
        //sort by due time
        return CollectionModel.of(customers);
    }
}
