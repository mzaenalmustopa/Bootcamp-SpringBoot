package com.mzaaenalmustopa.springbootdasar.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("Already to be used");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connection is closed");
    }
}
