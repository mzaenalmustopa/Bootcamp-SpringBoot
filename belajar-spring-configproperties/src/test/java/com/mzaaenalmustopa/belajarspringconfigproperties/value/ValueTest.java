package com.mzaaenalmustopa.belajarspringconfigproperties.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;


@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties properties;

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionName());
    }

    @SpringBootApplication
    public static class TestApplication{

        @Component
        @Getter
        public static class ApplicationProperties{

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionName;
        }
    }

}
