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
                .route( r -> r.path("/api/products/**")
                        .uri("https://catalogue-horae.herokuapp.com"))
                .route("catalogue-service", r -> r.path("/api/product-category/**")
                        .uri("https://catalogue-horae.herokuapp.com"))
                .route(r -> r.path("/api/checkout/**")
                        .uri("https://peaceful-reef-97616.herokuapp.com"))
                .route(r -> r.path("/api/orders/**")
                        .uri("https://peaceful-reef-97616.herokuapp.com"))
                .route(r -> r.path("/api/countries/**")
                        .uri("https://geo-horae.herokuapp.com"))
                .route(r -> r.path("/api/regions/**")
                        .uri("https://geo-horae.herokuapp.com"))
                .route(r -> r.path("/chatbot")
                        .uri("http://139.162.193.183:5000"))
                .build();
    }

}
