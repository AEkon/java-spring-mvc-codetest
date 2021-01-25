package com.example.demo.utils;

import com.example.demo.model.Customer;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * CustomerCreator - Factory for different lists of customers to test with.
 *
 * @author Alex Ekonomou
 */
public class CustomerCreator {

    private static final Customer olderCustomer;
    private static final Customer newerCustomer;

    static {
        olderCustomer = createTestCustomer();
        newerCustomer = createTestCustomer();
    }

    public static List<Customer> getListOfOne() {
        return Collections.singletonList(olderCustomer);
    }

    public static List<Customer> getListOfTwoOutOfOrder() {
        return Arrays.asList(newerCustomer, olderCustomer);
    }

    public static List<Customer> getListOfTwoInOrder() {
        return Arrays.asList(olderCustomer, newerCustomer);
    }

    private static Customer createTestCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Alex");
        customer.setDueTime(new DateTime(System.currentTimeMillis()));
        customer.setJoinTime(new DateTime(System.currentTimeMillis()));
        return customer;
    }

}
