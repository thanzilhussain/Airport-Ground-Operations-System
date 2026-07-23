package com.dorm.flightproject.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class Flight_Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
