package mzaaenalmustopa.springaop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("HelloTopa", helloService.hello("Topa"));
        Assertions.assertEquals("ByeTopa", helloService.bye("Topa"));

        helloService.test();
    }
}
