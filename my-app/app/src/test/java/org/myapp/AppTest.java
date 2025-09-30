package org.myapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.api.Api;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void test1() {
        Api api = new MyApiImpl();
        assertNotNull("Api import works", api.doSmth());
    }
}
