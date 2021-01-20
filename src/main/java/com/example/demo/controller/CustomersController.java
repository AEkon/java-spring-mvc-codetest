package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @PostMapping("/sorted")
    public CollectionModel<Customer> sort(@RequestBody ArrayList<Customer> customers) {
        List<Customer> sorted = new ArrayList<>();
        sorted.add(new Customer());
        //sort by due time
        return CollectionModel.of(sorted);
    }
}
