package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    @Configuration
    @Import({
            AuthService.class
    })
    private static class testConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(Ordered.TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testAware() {

        AuthService authService = applicationContext.getBean(AuthService.class);

        //Assertions.assertEquals("service.AuthService",authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(applicationContext, authService.getApplicationContext()  );
    }
}
