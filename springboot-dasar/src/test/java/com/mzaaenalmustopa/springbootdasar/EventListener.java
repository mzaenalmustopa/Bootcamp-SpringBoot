package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.listener.LoginSuccessListener;
import com.mzaaenalmustopa.springbootdasar.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListener {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            UserService.class
    })
    public static class testConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(Ordered.TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {

        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("eko","eko");
        userService.login("eko","salah");
        userService.login("kurniawan","salah");
    }
}
