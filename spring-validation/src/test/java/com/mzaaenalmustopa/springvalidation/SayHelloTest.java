package com.mzaaenalmustopa.springvalidation;

import com.mzaaenalmustopa.springvalidation.helper.SayHello;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SayHelloTest {

    @Autowired
    private SayHello sayHello;

    @Test
    void testSuccess() {
        String messsage = sayHello.sayHello("Topa");
        Assertions.assertEquals("HelloTopa", messsage);
    }

    @Test
    void testError() {
        Assertions.assertThrows(ConstraintViolationException.class, () ->{
           sayHello.sayHello("");
        });
    }
}
