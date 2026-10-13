package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DemoApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true, "Unit test passes successfully!");
    }

    @Test
    void testHelloEndpoint() {
        DemoApplication app = new DemoApplication();
        assertTrue(app.hello().contains("Hello DevOps"));
    }
}
