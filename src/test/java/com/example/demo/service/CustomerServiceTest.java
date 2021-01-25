package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.utils.CustomerCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    Testing the following:
    - Business logic works correctly.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    public void WhenNullCustomers_ThrowError() {
        assertThrows(IllegalArgumentException.class, () -> customerService.sort(null));
    }

    @Test
    public void WhenEmptyCustomers_ReturnEmptyList() {
        assertEquals(0, customerService.sort(Collections.emptyList()).size());
    }

    @Test
    public void WhenOneCustomer_ReturnSameCustomer() {
        //given
        Customer customer =  CustomerCreator.getListOfOne().get(0);
        //when
        List<Customer> sorted = customerService.sort(Collections.singletonList(customer));
        //then
        assertEquals(customer.toString(), sorted.get(0).toString());
    }

    @Test
    public void WhenTwoCustomersOutOfOrder_ReturnInOrder() {
        //given
        List<Customer> customers =  CustomerCreator.getListOfTwoOutOfOrder();
        //when
        List<Customer> sorted = customerService.sort(customers);
        //then
        assertEquals(customers.get(0).toString(), sorted.get(0).toString());
        assertEquals(customers.get(1).toString(), sorted.get(1).toString());
    }

}
