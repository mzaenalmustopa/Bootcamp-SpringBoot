package com.mzaaenalmustopa.springlogging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class LoggingTest {

    @Test
    void testOnLogging() {
        for (int i = 0; i <100_000; i++) {
            log.warn("Hello Muhamad Zaenal Mustopa {}",i);
        }
    }

    @Test
    void testLog() {
        log.info("Hello World");
        log.warn("Hello Spring Boot");
        log.error("Hello Muhamad Zaenal Mustopa");
    }
}
