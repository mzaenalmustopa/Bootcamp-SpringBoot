package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.configuration.BarConfiguration;
import com.mzaaenalmustopa.springbootdasar.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {

}
