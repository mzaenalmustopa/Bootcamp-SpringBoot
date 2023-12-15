package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.mzaaenalmustopa.springbootdasar.repository",
        "com.mzaaenalmustopa.springbootdasar.service",
        "com.mzaaenalmustopa.springbootdasar.configuration",
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
