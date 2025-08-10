package com.achrafrejouan.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running before all tests...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Running after all tests...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Setting up the test environment...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down the test environment...");
    }

    @Test
    public void testmethod1() {
        System.out.println("Test method 1 is running...");
    }
    @Test
    public void testmethod2() {
        System.out.println("Test method 2 is running...");
    }

}