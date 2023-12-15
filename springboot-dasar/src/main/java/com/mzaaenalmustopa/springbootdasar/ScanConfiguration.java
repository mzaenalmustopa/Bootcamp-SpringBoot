package com.mzaaenalmustopa.springbootdasar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = {
        "com.mzaaenalmustopa.springbootdasar.configuration"
})
public class ScanConfiguration {
}
