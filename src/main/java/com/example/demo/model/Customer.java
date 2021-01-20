package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    //Assuming id will not be larger than max int value
    private int id;
    private String name;
    private Date dueTime;
    private Date joinTime;
}
