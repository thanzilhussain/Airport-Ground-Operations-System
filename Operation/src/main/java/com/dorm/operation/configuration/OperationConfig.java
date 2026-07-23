package com.dorm.operation.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class OperationConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
