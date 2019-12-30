package com.example.springmysql;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;


@RunWith(SpringRestPactRunner.class)
@Provider("iProvider")
@PactFolder("src/test/resources/pacts")
@SpringBootTest
//@WebMvcTest(TicketController.class)
//@TestPropertySource(locations = "classpath:application.properties")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookTicketPactTest {
    private static ConfigurableApplicationContext application;

    @TestTarget
    public final Target target = new HttpTarget(9090);

    @BeforeClass
    public static void startSpring(){
        application = SpringApplication.run(SpringMysqlApplication.class);
    }

    @Test
    @State("ticket booking with valid id, amount, category")
    public void bookTicketTest() throws Exception {

    }
}








