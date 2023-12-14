package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.data.Bar;
import com.mzaaenalmustopa.springbootdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConfiguration {

    @Lazy
    // lazy atau malas method foo itu tidak akan di eksekusi kecuali method ini di akses dan di eksekusi
    @Bean
    // depends on untuk mempriotaskan mana yang akan di eksekusi terlebih dahulu dan bisa lebih dari satu
    @DependsOn({
            "bar"
    })
    public Foo foo(){
        log.info("Create new Foo ");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }
}
