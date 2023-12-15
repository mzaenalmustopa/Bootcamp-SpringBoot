package com.mzaaenalmustopa.springbootdasar;

import com.mzaaenalmustopa.springbootdasar.data.Connection;
import com.mzaaenalmustopa.springbootdasar.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {

    @Bean
    public Connection connection(){
        return new Connection();
    }

    //@Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    public Server server(){
        return new Server();
    }
}
