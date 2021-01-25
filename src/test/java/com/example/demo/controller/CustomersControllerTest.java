package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.utils.CustomerCreator;
import com.example.demo.utils.JSONMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
    Testing the following:
    - Endpoint should fail on wrong format
    - Endpoint should fail when no content sent
    - Endpoint should return data in correct structure
 */
public class CustomersControllerTest extends AbstractTest{

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void whenInvalidContentType_ThenReturns400() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_PDF_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void whenNoContent_ThenReturns400() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void whenValidSingleCustomerContent_ThenReturns200() throws Exception {
        List<Customer> customers = CustomerCreator.getListOfOne();

        String inputJson = JSONMapper.toJson(customers);

        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andExpect(request().asyncStarted())
                .andReturn();

        mvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(content().string(inputJson));
    }

    @Test
    public void whenValidCustomersOutOfOrderContent_ThenReturns200() throws Exception {
        List<Customer> inputCustomers = CustomerCreator.getListOfTwoOutOfOrder();

        String inputJson = JSONMapper.toJson(inputCustomers);

        List<Customer> responseCustomers = CustomerCreator.getListOfTwoInOrder();
        String responseJson = JSONMapper.toJson(responseCustomers);

        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andExpect(request().asyncStarted())
                .andReturn();

        mvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(content().string(responseJson));
    }
}
