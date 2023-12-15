package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.service.MerchantServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MerchantServiceImpl.class)
public class InheritanceConfigurable {

}
