package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.factory.PaymentGatewayFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PaymentGatewayFactoryBean.class
})
public class FactoryConfiguration {
}
