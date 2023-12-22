package com.mzaaenalmustopa.belajarspringconfigproperties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
public class ProfileTest {

    @Autowired
    private TestApplication.sayHello sayHello;

    @Test
    void testProfile() {
        Assertions.assertEquals("HelloTopafrom Local", sayHello.say("Topa"));
    }

    @SpringBootApplication
    public static class TestApplication {

        public interface sayHello {
            String say (String name);
        }

        @Component
        @Profile({"local"})
        public static class sayHelloLocal implements sayHello {

            @Override
            public String say(String name) {
                return "Hello" + name + "from Local";
            }
        }

        @Component
        @Profile({"production"})
        public static class  sayHelloProduction implements sayHello {

            @Override
            public String say(String name) {
                return "Hello" + name + "from production";
            }
        }
    }
}
