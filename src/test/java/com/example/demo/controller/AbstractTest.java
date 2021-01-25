package com.example.demo.controller;

import com.example.demo.JavaSpringMvcApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * AbstractTest - Opportunity for easier testing if more controllers and endpoints are created in the future.
 *
 * @author Alex Ekonomou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JavaSpringMvcApplication.class)
public abstract class AbstractTest {

    protected MockMvc mvc;
    protected String uri = "/api/customers/sorted";

    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}