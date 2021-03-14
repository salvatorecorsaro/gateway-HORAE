package com.scorsaro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("catalogue-service", r -> r.path("/api/products/**")
                        .uri("lb://catalogue-service"))
                .route("catalogue-service", r -> r.path("/api/product-category/**")
                        .uri("lb://catalogue-service"))
                .route("shop-service", r -> r.path("/api/checkout/**")
                        .uri("lb://shop-service"))
                .route("shop-service", r -> r.path("/api/orders/**")
                        .uri("lb://shop-service"))
                .route("geo-service", r -> r.path("/api/countries/**")
                        .uri("lb://geo-service"))
                .route("geo-service", r -> r.path("/api/regions/**")
                        .uri("lb://geo-service"))
                .route(r -> r.path("/chatbot")
                        .uri("http://localhost:5000"))
                .build();
    }

}
