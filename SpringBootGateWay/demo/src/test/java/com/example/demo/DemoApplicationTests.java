package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.route.RouteLocator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RouteLocator routeLocator;

    @Test
    void contextLoads() {
    }

    
    @Test
    void gatewayRegistersConfiguredRoutes() {
        var routeIds = routeLocator.getRoutes()
                .map(route -> route.getId())
                .collectList()
                .block();

        assertThat(routeIds).containsExactlyInAnyOrder(
                "flight-service",
                "gate-service",
                "crew-service",
                "fuel-service",
                "baggage-service",
                "operations-service");
    }

}