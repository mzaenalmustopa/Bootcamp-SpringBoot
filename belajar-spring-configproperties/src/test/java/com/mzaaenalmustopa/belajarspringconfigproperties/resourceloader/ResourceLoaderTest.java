package com.mzaaenalmustopa.belajarspringconfigproperties.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;


@SpringBootTest(classes = ResourceLoaderTest.testApplication.class)
public class ResourceLoaderTest {

    @Autowired
    private testApplication.SampleResource sampleResource;

    @Test
    void testResourceLoader() throws IOException {
        Assertions.assertEquals("Muhamad Zaenal Mustopa", sampleResource.getTxt().trim());
    }

    @SpringBootApplication
    public static class testApplication{

        @Component
        public static class SampleResource implements ResourceLoaderAware {

            @Setter
            private ResourceLoader resourceLoader;

            public String getTxt() throws IOException {
                Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
                try (var inputstream = resource.getInputStream()){
                    return new String(inputstream.readAllBytes());
                }
            }
        }
    }
}
